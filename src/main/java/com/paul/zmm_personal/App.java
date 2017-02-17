package com.paul.zmm_personal;

public class App {

	public static void main(String[] args) {
//		ResultInfoObject<KaolaContact> resultInfo = null;
//		resultInfo = new ResultInfoObject<>(200, "success");
//		resultInfo.setResult(new Object());
//		if (resultInfo.getObject() == null) {
//			KaolaContact kaolaContact = new KaolaContact();
//			kaolaContact.setId(1000L);
//			resultInfo.setObject(kaolaContact);
//		}
//		Long contactNewId1 = (resultInfo != null && resultInfo.getObject() != null
//				&& resultInfo.getObject().getId() != null) ? resultInfo.getObject().getId() : 0L;
//
//		System.out.println(contactNewId1);
//		Long contactNewId2 = (resultInfo == null || resultInfo.getObject() == null
//				|| resultInfo.getObject().getId() == null) ? 0L : resultInfo.getObject().getId();
//		System.out.println("everything's fine: " + contactNewId2);
	    
	    try {
	        String s = "this is a emssage";
	        System.out.println(s);
	        throw new RuntimeException("runtime exception");
	    }catch (Exception e){
//	        System.out.println(e.getMessage());
//	        System.out.println("wo jiu bu chu li");
	    }

	}
}
