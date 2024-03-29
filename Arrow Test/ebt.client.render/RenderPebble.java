package ebt.client.render;

import net.minecraft.src.Entity;
import net.minecraft.src.ModelBase;
import net.minecraft.src.Render;
import net.minecraft.src.Tessellator;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import ebt.common.EntityPebble;
import ebt.common.ModelPebble;



public class RenderPebble extends Render
{
	protected ModelBase ModelPebble;
	
	public RenderPebble()
    {
        this.shadowSize = 0.1F;
        this.ModelPebble = new ModelPebble();
    }
	
	
	
    public void renderFShot(EntityPebble var1, double var2, double var4, double var6, float var8, float var9)
    {
        if (var1.prevRotationYaw != 0.0F || var1.prevRotationPitch != 0.0F)
        {
        	//this.modelFShot.render(var1, 0F, 0F, 0F, 11, 2, 2);
            this.loadTexture("/magicItems/common/magictextures/flameshot.png");
            GL11.glPushMatrix();
            GL11.glTranslatef((float)var2, (float)var4, (float)var6);
            GL11.glRotatef(var1.prevRotationYaw + (var1.rotationYaw - var1.prevRotationYaw) * var9 - 90.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(var1.prevRotationPitch + (var1.rotationPitch - var1.prevRotationPitch) * var9, 0.0F, 0.0F, 1.0F);
            Tessellator var10 = Tessellator.instance;
            byte var11 = 0;
            float var12 = 0.0F;
            float var13 = 0.5F;
            float var14 = (float)(0 + var11 * 10) / 32.0F;
            float var15 = (float)(5 + var11 * 10) / 32.0F;
            float var16 = 0.0F;
            float var17 = 0.15625F;
            float var18 = (float)(5 + var11 * 10) / 32.0F;
            float var19 = (float)(10 + var11 * 10) / 32.0F;
            float var20 = 0.05625F;
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);



            GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
            GL11.glScalef(var20, var20, var20);
            GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
            GL11.glNormal3f(var20, 0.0F, 0.0F);
            var10.startDrawingQuads();
            var10.addVertexWithUV(-7.0D, -2.0D, -2.0D, (double)var16, (double)var18);
            var10.addVertexWithUV(-7.0D, -2.0D, 2.0D, (double)var17, (double)var18);
            var10.addVertexWithUV(-7.0D, 2.0D, 2.0D, (double)var17, (double)var19);
            var10.addVertexWithUV(-7.0D, 2.0D, -2.0D, (double)var16, (double)var19);
            var10.draw();
            GL11.glNormal3f(-var20, 0.0F, 0.0F);
            var10.startDrawingQuads();
            var10.addVertexWithUV(-7.0D, 2.0D, -2.0D, (double)var16, (double)var18);
            var10.addVertexWithUV(-7.0D, 2.0D, 2.0D, (double)var17, (double)var18);
            var10.addVertexWithUV(-7.0D, -2.0D, 2.0D, (double)var17, (double)var19);
            var10.addVertexWithUV(-7.0D, -2.0D, -2.0D, (double)var16, (double)var19);
            var10.draw();

            for (int var23 = 0; var23 < 4; ++var23)
            {
                GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
                GL11.glNormal3f(0.0F, 0.0F, var20);
                var10.startDrawingQuads();
                var10.addVertexWithUV(-8.0D, -2.0D, 0.0D, (double)var12, (double)var14);
                var10.addVertexWithUV(8.0D, -2.0D, 0.0D, (double)var13, (double)var14);
                var10.addVertexWithUV(8.0D, 2.0D, 0.0D, (double)var13, (double)var15);
                var10.addVertexWithUV(-8.0D, 2.0D, 0.0D, (double)var12, (double)var15);
                var10.draw();
            }

            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            GL11.glPopMatrix();
        }
    }
    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probability, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9)
    {
        this.renderFShot((EntityPebble)var1, var2, var4, var6, var8, var9);
    }
}
