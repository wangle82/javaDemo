package phaser.demo2.extthread;

import phaser.demo2.tools.PrintTools;

import java.util.concurrent.Phaser;


public class ThreadB extends Thread {

	private Phaser phaser;

	public ThreadB(Phaser phaser) {
		super();
		this.phaser = phaser;
	}

	public void run() {
		PrintTools.methodA();
	}

}
