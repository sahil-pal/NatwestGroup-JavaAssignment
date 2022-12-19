package com.natwest.app;

import org.springframework.stereotype.Component;

@Component
public class AppConstants {

	public static int WIN_STATUS_CODE = 1;
	public static int LOSS_STATUS_CODE = -1;
	public static int TIE_STATUS_CODE = 0;
	
	public static String SCISSOR="scissor";
	public static String STONE="stone";
	public static String PAPER="paper";
}
