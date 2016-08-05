package cn.zxnui.www;

/**
 * 角色落脚的平台
 */
public class Platform extends DynamicGameObject {
	public static final float PLATFORM_WIDTH = 2;//平台宽度
	public static final float PLATFORM_HEIGHT = 0.5f;//平台高度
	public static final int PLATFORM_TYPE_STATIC = 0;//静态的平台
	public static final int PLATFORM_TYPE_MOVING = 1;//移动的平台
	public static final int PLATFORM_STATE_NORMAL = 0;//正餐
	public static final int PLATFORM_STATE_PULVERIZING = 1;//粉碎
	public static final float PLATFORM_PULVERIZE_TIME = 0.2f * 4;//粉碎时间
	public static final float PLATFORM_VELOCITY = 2;//速度

	int type;
	int state;
	float stateTime;

	public Platform (int type, float x, float y) {
		super(x, y, PLATFORM_WIDTH, PLATFORM_HEIGHT);
		this.type = type;
		this.state = PLATFORM_STATE_NORMAL;
		this.stateTime = 0;
		if (type == PLATFORM_TYPE_MOVING) {//给予移动平台速度
			velocity.x = PLATFORM_VELOCITY;//横向移动速度
		}
	}

	public void update (float deltaTime) {
		if (type == PLATFORM_TYPE_MOVING) {
			position.add(velocity.x * deltaTime, 0);
			bounds.x = position.x - PLATFORM_WIDTH / 2;
			bounds.y = position.y - PLATFORM_HEIGHT / 2;

			if (position.x < PLATFORM_WIDTH / 2) {
				velocity.x = -velocity.x;
				position.x = PLATFORM_WIDTH / 2;
			}
			if (position.x > World.WORLD_WIDTH - PLATFORM_WIDTH / 2) {
				velocity.x = -velocity.x;
				position.x = World.WORLD_WIDTH - PLATFORM_WIDTH / 2;
			}
		}

		stateTime += deltaTime;
	}

	public void pulverize () {
		state = PLATFORM_STATE_PULVERIZING;
		stateTime = 0;
		velocity.x = 0;
	}
}
