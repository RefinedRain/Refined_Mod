package net.refinedrain.refinedmod.entity.spells.moon_slash;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.PoseStack.Pose;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class MoonSlashRenderer extends EntityRenderer<MoonSlashProjectile> {
    public static ResourceLocation id(@NotNull String path) {
        return new ResourceLocation("refined_mod", path);
    }

    private static final ResourceLocation TEXTURE = id("textures/entity/moon_slash/moon_slash_large.png");

    public MoonSlashRenderer(Context context) {
        super(context);
    }

    @Override
    public void render(MoonSlashProjectile entity, float yaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int light) {
        poseStack.pushPose();

        Pose pose = poseStack.last();
        Matrix4f poseMatrix = pose.pose();
        Matrix3f normalMatrix = pose.normal();

        poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entity.yRotO, entity.getYRot())));
        poseStack.mulPose(Axis.XP.rotationDegrees(-Mth.lerp(partialTicks, entity.xRotO, entity.getXRot())));

        entity.animationTime++;

        float oldWidth = (float) entity.oldBB.getXsize();
        float width = entity.getBbWidth();
        width = oldWidth + (width - oldWidth) * Math.min(partialTicks, 1);

        RenderType translucentRenderType = RenderType.entityTranslucent(getTextureLocation(entity));
        VertexConsumer vertexConsumer = bufferSource.getBuffer(translucentRenderType);

        drawSlash(pose, entity, vertexConsumer, light, width, entity.getAlpha());

        poseStack.popPose();

        super.render(entity, yaw, partialTicks, poseStack, bufferSource, light);
    }

    private void drawSlash(Pose pose, MoonSlashProjectile entity, VertexConsumer vertexConsumer, int light, float width, float alpha) {
        Matrix4f poseMatrix = pose.pose();
        Matrix3f normalMatrix = pose.normal();

        float halfWidth = width * .5f;

        // Set the color with alpha
        int color = (int) (255 * alpha);

        vertexConsumer.vertex(poseMatrix, -halfWidth, 0.0f, -halfWidth).color(255, 255, 255, color).uv(0.0f, 0.0f).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(normalMatrix, 0f, 1f, 0f).endVertex();
        vertexConsumer.vertex(poseMatrix, halfWidth, 0.0f, -halfWidth).color(255, 255, 255, color).uv(1.0f, 0.0f).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(normalMatrix, 0f, 1f, 0f).endVertex();
        vertexConsumer.vertex(poseMatrix, halfWidth, 0.0f, halfWidth).color(255, 255, 255, color).uv(1.0f, 1.0f).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(normalMatrix, 0f, 1f, 0f).endVertex();
        vertexConsumer.vertex(poseMatrix, -halfWidth, 0.0f, halfWidth).color(255, 255, 255, color).uv(0.0f, 1.0f).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(normalMatrix, 0f, 1f, 0f).endVertex();
    }

    @Override
    public ResourceLocation getTextureLocation(@NotNull MoonSlashProjectile entity) {
        return TEXTURE;
    }
}
