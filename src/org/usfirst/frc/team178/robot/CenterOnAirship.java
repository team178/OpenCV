package org.usfirst.frc.team178.robot;

import org.usfirst.frc.team178.robot.VisionStreamer;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Command;

public class CenterOnAirship extends Command {
	
	private RobotDrive drive;
	private VisionStreamer frontCamera = new VisionStreamer("frontCamera", "10.1.78.109");

	private final Object imgLock = new Object();
	
	
	public void centerAndAdvance() {
		double centerX;
		synchronized (imgLock) {
			centerX = frontCamera.getTapeCenterX();
		}
		double turn = centerX - (frontCamera.getIMG_WIDTH() / 2);
		drive.arcadeDrive(-0.6, turn * 0.005);
	}
	
	Command.isFinished();
}