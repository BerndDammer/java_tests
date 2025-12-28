package terminaltests;

import java.net.MalformedURLException;

import gateway.hook.HookOpenOCDTcl;
import gateway.hook.Register;
import gateway.hook.RegisterList;

public class t3
{
	static RegisterList registerList;
	public static void main(String[] args) throws MalformedURLException
	{
		final Parameter parameter = new Parameter(args);
		HookOpenOCDTcl hookOpenOCDTcl = new HookOpenOCDTcl(parameter);
		
		registerList = new RegisterList();
		Register r;
		
		r = new Register("X", 0x1000_0000);
		registerList.put(r.address, r);
		r = new Register("X", 0x1000_0004);
		registerList.put(r.address, r);
		hookOpenOCDTcl.setRegisterList(registerList);
		hookOpenOCDTcl.get();
		for(Register ri : registerList.values())
		{
			p("" + ri.name + "    " +  Integer.toHexString(ri.data));
		}
		hookOpenOCDTcl.close();
	}
	private static void p(String s)
	{
		System.out.println(s);
	}
}


