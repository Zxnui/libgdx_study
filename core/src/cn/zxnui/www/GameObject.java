package cn.zxnui.www;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GameObject {
	public final Vector2 position;//物体位置
	public final Rectangle bounds;//物体矩形框

	/**
	 * 2D物体基本属性
	 * @param x			物体坐标x轴参数
	 * @param y			物体坐标y轴参数
	 * @param width		物体宽度
     * @param height	物体高度
     */
	public GameObject (float x, float y, float width, float height) {
		this.position = new Vector2(x, y);
		this.bounds = new Rectangle(x - width / 2, y - height / 2, width, height);
	}
}
