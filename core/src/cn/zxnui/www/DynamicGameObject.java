package cn.zxnui.www;

import com.badlogic.gdx.math.Vector2;

/**
 * 活动物体抽象
 */
public class DynamicGameObject extends GameObject {
	public final Vector2 velocity;//速度,入参2个，第一个时x轴移动速度，第二个是y移动速度
	public final Vector2 accel;//加速度

	public DynamicGameObject (float x, float y, float width, float height) {
		super(x, y, width, height);
		velocity = new Vector2();
		accel = new Vector2();
	}
}
