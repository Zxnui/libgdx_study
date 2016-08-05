package cn.zxnui.www;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ZxnuiGame extends Game {
	public SpriteBatch batcher;

	@Override
	public void create () {
		batcher = new SpriteBatch();

		//加载配置文件
		Settings.load();

		//加载资源
		Assets.load();

		//屏幕加载
		setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render() {
		super.render();
	}

}
