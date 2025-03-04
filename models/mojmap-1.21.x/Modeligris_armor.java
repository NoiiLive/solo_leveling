// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modeligris_armor<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "igris_armor"), "main");
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart LeftLeg;
	private final ModelPart RightLeg;
	private final ModelPart LeftBoot;
	private final ModelPart RightBoot;

	public Modeligris_armor(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.LeftArm = root.getChild("LeftArm");
		this.RightArm = root.getChild("RightArm");
		this.LeftLeg = root.getChild("LeftLeg");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftBoot = root.getChild("LeftBoot");
		this.RightBoot = root.getChild("RightBoot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(40, 17)
						.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.6F)).texOffs(40, 0)
						.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 9.0F, 8.0F, new CubeDeformation(0.75F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head_r1 = Head.addOrReplaceChild("head_r1",
				CubeListBuilder.create().texOffs(40, 33).addBox(-2.0F, -6.5F, -6.25F, 4.0F, 4.0F, 11.0F,
						new CubeDeformation(0.5F)),
				PartPose.offsetAndRotation(0.0F, 11.9495F, 10.516F, -0.9163F, 0.0F, 0.0F));

		PartDefinition head_r2 = Head.addOrReplaceChild("head_r2",
				CubeListBuilder.create().texOffs(0, 25).addBox(-3.0F, -3.0F, -14.0F, 6.0F, 6.0F, 14.0F,
						new CubeDeformation(0.5F)),
				PartPose.offsetAndRotation(0.0F, 4.9761F, 9.9059F, -1.4835F, 0.0F, 0.0F));

		PartDefinition head_r3 = Head.addOrReplaceChild("head_r3",
				CubeListBuilder.create().texOffs(32, 48).addBox(-2.0F, -2.0F, -18.0F, 4.0F, 4.0F, 10.0F,
						new CubeDeformation(0.5F)),
				PartPose.offsetAndRotation(0.0F, -1.2117F, 12.1202F, -1.1345F, 0.0F, 0.0F));

		PartDefinition head_r4 = Head.addOrReplaceChild("head_r4",
				CubeListBuilder.create().texOffs(18, 83).addBox(-1.0F, -6.5837F, -1.8963F, 2.0F, 9.0F, 3.0F,
						new CubeDeformation(0.5F)),
				PartPose.offsetAndRotation(0.0F, -9.0F, 1.5F, -0.5236F, 0.0F, 0.0F));

		PartDefinition head_r5 = Head.addOrReplaceChild("head_r5",
				CubeListBuilder.create().texOffs(72, 6).addBox(-1.0F, -10.5F, -1.5F, 2.0F, 12.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.2761F, -6.0F, -0.7185F, 0.0F, -0.7418F, 0.0F));

		PartDefinition head_r6 = Head.addOrReplaceChild("head_r6",
				CubeListBuilder.create().texOffs(68, 80).addBox(-1.0F, -5.5F, -1.5F, 2.0F, 7.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.2761F, -6.0F, -0.7185F, 0.0F, 0.7418F, 0.0F));

		PartDefinition head_r7 = Head.addOrReplaceChild("head_r7",
				CubeListBuilder.create().texOffs(80, 82).addBox(-7.0F, -10.5F, 0.5F, 4.0F, 8.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0261F, -2.0F, -5.2185F, 0.0436F, 0.0F, 0.0F));

		PartDefinition head_r8 = Head.addOrReplaceChild("head_r8",
				CubeListBuilder.create().texOffs(80, 64).mirror()
						.addBox(-1.0F, -2.5F, -1.5F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.7761F, -2.0F, -2.7185F, 0.0F, -0.7418F, 0.0F));

		PartDefinition head_r9 = Head.addOrReplaceChild("head_r9",
				CubeListBuilder.create().texOffs(80, 64).addBox(-1.0F, -2.5F, -1.5F, 2.0F, 4.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.7761F, -2.0F, -2.7185F, 0.0F, 0.7418F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(0, 56)
						.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.261F)).texOffs(60, 48)
						.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)).texOffs(72, 0)
						.addBox(-4.0F, 9.5F, -2.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.75F)).texOffs(0, 45)
						.addBox(-5.0F, -1.25F, -3.0F, 10.0F, 5.0F, 6.0F, new CubeDeformation(0.4F)),
				PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition torso_r1 = Body
				.addOrReplaceChild("torso_r1",
						CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -0.5F, -1.0F, 18.0F, 23.0F, 2.0F,
								new CubeDeformation(0.4F)),
						PartPose.offsetAndRotation(0.0F, -1.0F, 3.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition torso_r2 = Body.addOrReplaceChild("torso_r2",
				CubeListBuilder.create().texOffs(70, 33).mirror()
						.addBox(-1.0F, -4.0F, -2.75F, 3.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.5F, 13.0F, -0.25F, 0.0F, 0.0F, 0.1745F));

		PartDefinition torso_r3 = Body.addOrReplaceChild("torso_r3",
				CubeListBuilder.create().texOffs(70, 33).addBox(-2.0F, -4.0F, -2.75F, 3.0F, 7.0F, 6.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.5F, 13.0F, -0.25F, 0.0F, 0.0F, -0.1745F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm",
				CubeListBuilder.create().texOffs(64, 64)
						.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.26F)).texOffs(52, 80)
						.addBox(-1.0F, 4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.5F)).texOffs(24, 56)
						.addBox(3.0F, 5.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(34, 80)
						.addBox(0.1078F, -0.5532F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, 14.0F, 0.0F));

		PartDefinition left_arm_r1 = LeftArm.addOrReplaceChild("left_arm_r1",
				CubeListBuilder.create().texOffs(72, 22)
						.addBox(-5.0F, 0.5F, -3.5F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(24, 62)
						.addBox(-3.0F, -1.5F, -3.5F, 5.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.75F, -2.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition left_arm_r2 = LeftArm
				.addOrReplaceChild("left_arm_r2",
						CubeListBuilder.create().texOffs(34, 73).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 3.0F, 4.0F,
								new CubeDeformation(0.75F)),
						PartPose.offsetAndRotation(3.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(64, 64)
				.mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.26F)).mirror(false)
				.texOffs(52, 80).mirror().addBox(-3.0F, 4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.5F))
				.mirror(false).texOffs(24, 56).mirror()
				.addBox(-5.0F, 5.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(34, 80)
				.mirror().addBox(-4.1078F, -0.5532F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-5.0F, 14.0F, 0.0F));

		PartDefinition right_arm_r1 = RightArm.addOrReplaceChild("right_arm_r1",
				CubeListBuilder.create().texOffs(72, 22).mirror()
						.addBox(3.0F, 0.5F, -3.5F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(24, 62).mirror()
						.addBox(-2.0F, -1.5F, -3.5F, 5.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-2.75F, -2.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition right_arm_r2 = RightArm.addOrReplaceChild("right_arm_r2",
				CubeListBuilder.create().texOffs(34, 73).mirror()
						.addBox(-0.5F, -2.0F, -2.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.75F)).mirror(false),
				PartPose.offsetAndRotation(-3.0F, 5.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(48, 64)
				.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.26F)),
				PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg",
				CubeListBuilder.create().texOffs(48, 64).mirror()
						.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.26F)).mirror(false),
				PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition LeftBoot = partdefinition.addOrReplaceChild("LeftBoot", CubeListBuilder.create().texOffs(18, 73)
				.addBox(-2.0F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.5F)),
				PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition right_leg_r1 = LeftBoot.addOrReplaceChild("right_leg_r1",
				CubeListBuilder.create().texOffs(84, 6).addBox(-2.0F, -1.5F, -0.5F, 4.0F, 3.0F, 1.0F,
						new CubeDeformation(0.75F)),
				PartPose.offsetAndRotation(0.0F, 6.5F, -2.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition RightBoot = partdefinition.addOrReplaceChild("RightBoot",
				CubeListBuilder.create().texOffs(18, 73).mirror()
						.addBox(-2.0F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.5F)).mirror(false),
				PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition left_leg_r1 = RightBoot.addOrReplaceChild("left_leg_r1",
				CubeListBuilder.create().texOffs(84, 6).mirror()
						.addBox(-2.0F, -1.5F, -0.5F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.75F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 6.5F, -2.0F, 0.0873F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}