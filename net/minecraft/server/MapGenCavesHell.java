package net.minecraft.server;

import java.util.Random;

public class MapGenCavesHell extends MapGenBase {

    public MapGenCavesHell() {}

    protected void a(int i, int j, byte[] abyte, double d0, double d1, double d2) {
        this.a(i, j, abyte, d0, d1, d2, 1.0F + this.c.nextFloat() * 6.0F, 0.0F, 0.0F, -1, -1, 0.5D);
    }

    protected void a(int i, int j, byte[] abyte, double d0, double d1, double d2, float f, float f1, float f2, int k, int l, double d3) {
        double d4 = (double) (i * 16 + 8);
        double d5 = (double) (j * 16 + 8);
        float f3 = 0.0F;
        float f4 = 0.0F;
        Random random = new Random(this.c.nextLong());

        if (l <= 0) {
            int i1 = this.b * 16 - 16;

            l = i1 - random.nextInt(i1 / 4);
        }

        boolean flag = false;

        if (k == -1) {
            k = l / 2;
            flag = true;
        }

        int j1 = random.nextInt(l / 2) + l / 4;

        for (boolean flag1 = random.nextInt(6) == 0; k < l; ++k) {
            double d6 = 1.5D + (double) (MathHelper.sin((float) k * 3.1415927F / (float) l) * f * 1.0F);
            double d7 = d6 * d3;
            float f5 = MathHelper.cos(f2);
            float f6 = MathHelper.sin(f2);

            d0 += (double) (MathHelper.cos(f1) * f5);
            d1 += (double) f6;
            d2 += (double) (MathHelper.sin(f1) * f5);
            if (flag1) {
                f2 *= 0.92F;
            } else {
                f2 *= 0.7F;
            }

            f2 += f4 * 0.1F;
            f1 += f3 * 0.1F;
            f4 *= 0.9F;
            f3 *= 0.75F;
            f4 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
            f3 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0F;
            if (!flag && k == j1 && f > 1.0F) {
                this.a(i, j, abyte, d0, d1, d2, random.nextFloat() * 0.5F + 0.5F, f1 - 1.5707964F, f2 / 3.0F, k, l, 1.0D);
                this.a(i, j, abyte, d0, d1, d2, random.nextFloat() * 0.5F + 0.5F, f1 + 1.5707964F, f2 / 3.0F, k, l, 1.0D);
                return;
            }

            if (flag || random.nextInt(4) != 0) {
                double d8 = d0 - d4;
                double d9 = d2 - d5;
                double d10 = (double) (l - k);
                double d11 = (double) (f + 2.0F + 16.0F);

                if (d8 * d8 + d9 * d9 - d10 * d10 > d11 * d11) {
                    return;
                }

                if (d0 >= d4 - 16.0D - d6 * 2.0D && d2 >= d5 - 16.0D - d6 * 2.0D && d0 <= d4 + 16.0D + d6 * 2.0D && d2 <= d5 + 16.0D + d6 * 2.0D) {
                    int k1 = MathHelper.floor(d0 - d6) - i * 16 - 1;
                    int l1 = MathHelper.floor(d0 + d6) - i * 16 + 1;
                    int i2 = MathHelper.floor(d1 - d7) - 1;
                    int j2 = MathHelper.floor(d1 + d7) + 1;
                    int k2 = MathHelper.floor(d2 - d6) - j * 16 - 1;
                    int l2 = MathHelper.floor(d2 + d6) - j * 16 + 1;

                    if (k1 < 0) {
                        k1 = 0;
                    }

                    if (l1 > 16) {
                        l1 = 16;
                    }

                    if (i2 < 1) {
                        i2 = 1;
                    }
                    //
                    this.d.getClass();
                    if (j2 > 128 - 8) {

                        j2 = 128 - 8;
                    }

                    if (k2 < 0) {
                        k2 = 0;
                    }

                    if (l2 > 16) {
                        l2 = 16;
                    }

                    boolean flag2 = false;

                    int i3;
                    int j3;
                    int k3;

                    for (k3 = k1; !flag2 && k3 < l1; ++k3) {
                        for (int l3 = k2; !flag2 && l3 < l2; ++l3) {
                            for (int i4 = j2 + 1; !flag2 && i4 >= i2 - 1; --i4) {
                                i3 = k3 * 16 + l3;

                                j3 = i3 * 128 + i4;
                                if (i4 >= 0) {

                                    if (i4 < 128) {
                                        if (abyte[j3] == Block.LAVA.id || abyte[j3] == Block.STATIONARY_LAVA.id) {
                                            flag2 = true;
                                        }

                                        if (i4 != i2 - 1 && k3 != k1 && k3 != l1 - 1 && l3 != k2 && l3 != l2 - 1) {
                                            i4 = i2;
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (!flag2) {
                        for (k3 = k1; k3 < l1; ++k3) {
                            double d12 = ((double) (k3 + i * 16) + 0.5D - d0) / d6;

                            for (j3 = k2; j3 < l2; ++j3) {
                                double d13 = ((double) (j3 + j * 16) + 0.5D - d2) / d6;

                                i3 = k3 * 16 + j3;

                                int j4 = i3 * 128 + j2;

                                for (int k4 = j2 - 1; k4 >= i2; --k4) {
                                    double d14 = ((double) k4 + 0.5D - d1) / d7;

                                    if (d14 > -0.7D && d12 * d12 + d14 * d14 + d13 * d13 < 1.0D) {
                                        byte b0 = abyte[j4];

                                        if (b0 == Block.NETHERRACK.id || b0 == Block.DIRT.id || b0 == Block.GRASS.id) {
                                            abyte[j4] = 0;
                                        }
                                    }

                                    --j4;
                                }
                            }
                        }

                        if (flag) {
                            break;
                        }
                    }
                }
            }
        }
    }

    protected void a(World world, int i, int j, int k, int l, byte[] abyte) {
        int i1 = this.c.nextInt(this.c.nextInt(this.c.nextInt(10) + 1) + 1);

        if (this.c.nextInt(5) != 0) {
            i1 = 0;
        }

        for (int j1 = 0; j1 < i1; ++j1) {
            double d0 = (double) (i * 16 + this.c.nextInt(16));
            Random random = this.c;

            world.getClass();
            double d1 = (double) random.nextInt(128);
            double d2 = (double) (j * 16 + this.c.nextInt(16));
            int k1 = 1;

            if (this.c.nextInt(4) == 0) {
                this.a(k, l, abyte, d0, d1, d2);
                k1 += this.c.nextInt(4);
            }

            for (int l1 = 0; l1 < k1; ++l1) {
                float f = this.c.nextFloat() * 3.1415927F * 2.0F;
                float f1 = (this.c.nextFloat() - 0.5F) * 2.0F / 8.0F;
                float f2 = this.c.nextFloat() * 2.0F + this.c.nextFloat();

                this.a(k, l, abyte, d0, d1, d2, f2 * 2.0F, f, f1, 0, 0, 0.5D);
            }
        }
    }
}
