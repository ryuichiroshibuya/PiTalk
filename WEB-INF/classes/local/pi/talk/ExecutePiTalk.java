package local.pi.talk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ExecutePiTalk {
	private String cmd = getJSay();
	public void Process(String msg) throws InterruptedException {
		ProcessBuilder pb = new ProcessBuilder(cmd, msg);
		Process p = null;
		try {
			p = pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		Catcher c = new Catcher(br);
		c.start();

		p.waitFor();
		p.destroy();
		    
		System.out.println(c.out.toString());
	}
	
	public List<String> MessageSplit(String str){
		// メッセージの配列化
		List<String> list = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(str, "。");
		while (tokenizer.hasMoreTokens()) {
			list.add(tokenizer.nextToken());
		}
		return list;
	}
	public void Talk(String str) throws InterruptedException{
		// メッセージの配列化
		StringTokenizer tokenizer = new StringTokenizer(str, "。");
		while (tokenizer.hasMoreTokens()) {
			this.Process(tokenizer.nextToken());
		}
	}
	public static String getJSay(){
		String cmd = null;
		
		if(getConfigure.getOSName().equals("Linux")){
			cmd = "/usr/local/bin/jsay";
		}else{
			cmd = "dir";
		}
		return cmd;
	}
}

class Catcher extends Thread {
	  Reader in;
	  StringWriter out = new StringWriter();
	  public Catcher(Reader in) {
	    this.in = in;
	  }

	  public void run() {
	    int c;
	    try {
	      while ((c = in.read()) != -1) {
	        out.write((char)c);
	      }
	    } catch (IOException e) {
	      e.printStackTrace();
	    }

	  }
}
