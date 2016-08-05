package cn.zxnui.www;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * 动画
 */
public class Animation {
	public static final int ANIMATION_LOOPING = 0;//循环动画
	public static final int ANIMATION_NONLOOPING = 1;//非循环动画

	final TextureRegion[] keyFrames;

	//帧持续时间
	final float frameDuration;

	public Animation (float frameDuration, TextureRegion... keyFrames) {
		this.frameDuration = frameDuration;
		this.keyFrames = keyFrames;
	}

	/**
	 * 获取动画
	 * @param stateTime	动画持续时间
	 * @param mode	动画状态 0：循环 1：非循环
     * @return
     */
	public TextureRegion getKeyFrame (float stateTime, int mode) {
		int frameNumber = (int)(stateTime / frameDuration);

		if (mode == ANIMATION_NONLOOPING) {
			frameNumber = Math.min(keyFrames.length - 1, frameNumber);
		} else {
			frameNumber = frameNumber % keyFrames.length;
		}
		return keyFrames[frameNumber];
	}
}
