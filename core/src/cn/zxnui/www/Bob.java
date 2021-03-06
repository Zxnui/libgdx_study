package cn.zxnui.www;

public class Bob extends DynamicGameObject {
	public static final int BOB_STATE_JUMP = 0;//角色跳起
	public static final int BOB_STATE_FALL = 1;//角色落下
	public static final int BOB_STATE_HIT = 2;//角色撞击
	public static final float BOB_JUMP_VELOCITY = 11;
	public static final float BOB_MOVE_VELOCITY = 20;
	public static final float BOB_WIDTH = 0.8f;//角色在场景，宽度
	public static final float BOB_HEIGHT = 0.8f;//角色在场景，高度

	int state;
	float stateTime;

	public Bob (float x, float y) {
		super(x, y, BOB_WIDTH, BOB_HEIGHT);//加载人物位置和体积信息
		state = BOB_STATE_FALL;//默认落下
		stateTime = 0;//默认开始
	}

	public void update (float deltaTime) {
		velocity.add(World.gravity.x * deltaTime, World.gravity.y * deltaTime);
		position.add(velocity.x * deltaTime, velocity.y * deltaTime);
		bounds.x = position.x - bounds.width / 2;
		bounds.y = position.y - bounds.height / 2;

		if (velocity.y > 0 && state != BOB_STATE_HIT) {
			if (state != BOB_STATE_JUMP) {
				state = BOB_STATE_JUMP;
				stateTime = 0;
			}
		}

		if (velocity.y < 0 && state != BOB_STATE_HIT) {
			if (state != BOB_STATE_FALL) {
				state = BOB_STATE_FALL;
				stateTime = 0;
			}
		}

		if (position.x < 0) position.x = World.WORLD_WIDTH;
		if (position.x > World.WORLD_WIDTH) position.x = 0;

		stateTime += deltaTime;
	}

	public void hitSquirrel () {
		velocity.set(0, 0);
		state = BOB_STATE_HIT;
		stateTime = 0;
	}

	public void hitPlatform () {
		velocity.y = BOB_JUMP_VELOCITY;
		state = BOB_STATE_JUMP;
		stateTime = 0;
	}

	public void hitSpring () {
		velocity.y = BOB_JUMP_VELOCITY * 1.5f;
		state = BOB_STATE_JUMP;
		stateTime = 0;
	}
}
