package com.ninox.ninoxerp.exception;

public class NinoxException extends NinoxBaseException {
	
	private static final long serialVersionUID = 1L;
	
	public NinoxException() {
		super(NinoxExceptionCodes.UNKN_ERROR);
	}
	
	public static class DBGenericException extends NinoxBaseException {
		
		private static final long serialVersionUID = 233373868379842620L;

		public DBGenericException() {
			super(NinoxExceptionCodes.DB_ERROR);
		}
	}
	
	public static class ValidationException extends NinoxBaseException {

		private static final long serialVersionUID = 7166469450061609797L;
		
		public ValidationException() {
			super(NinoxExceptionCodes.INVALID_DATA);
		}
	}
	
	public static class SaveException extends NinoxBaseException {
		
		private static final long serialVersionUID = -7981212841584012082L;

		public SaveException() {
			super(NinoxExceptionCodes.SAVE_FAILED);
		}
	}
	
	public static class SaveSuccessException extends NinoxBaseException {

		private static final long serialVersionUID = 3836820547959643284L;

		public SaveSuccessException() {
			super(NinoxExceptionCodes.SAVE_SUCCESS);
		}
	}
	
	public static class NoDataFoundException extends NinoxBaseException {

		private static final long serialVersionUID = 8367142197861225059L;

		public NoDataFoundException() {
			super(NinoxExceptionCodes.NO_DATA_FOUND);
		}
	}
}
