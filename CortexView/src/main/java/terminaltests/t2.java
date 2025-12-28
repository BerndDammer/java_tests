package terminaltests;

import java.net.MalformedURLException;

import gateway.hook.HookOpenOCDTcl;

public class t2
{

	public static void main(String[] args) throws MalformedURLException
	{
		final Parameter parameter = new Parameter(args);
		HookOpenOCDTcl hookOpenOCDTcl = new HookOpenOCDTcl(parameter);

		hookOpenOCDTcl.snapRegs();
		hookOpenOCDTcl.close();
	}
}
