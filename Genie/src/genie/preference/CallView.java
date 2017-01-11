package genie.preference;

import genie.MethodCall.SOAPClient4XG;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

//import connection.MyJsonSrc;

public class CallView extends PreferencePage implements
		IWorkbenchPreferencePage {
	private Text text;
	private Text text_1;
	private Label label_2;
	Button btnRemote;
	Button btnLoacl;
	/**
	 * @wbp.parser.constructor
	 */
	public CallView() {
		// TODO Auto-generated constructor stub
	}

	public CallView(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public CallView(String title, ImageDescriptor image) {
		super(title, image);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}

	@Override
	protected Control createContents(Composite parent) {
		Composite c = new Composite(parent, SWT.NONE);
		
		final Label label = new Label(c, SWT.NONE);
		label.setBounds(10, 104, 75, 12);
		label.setText("UserName");
		
		text = new Text(c, SWT.BORDER);
		text.setBounds(91, 101, 264, 18);
		
		
		Label label_1 = new Label(c, SWT.NONE);
		label_1.setBounds(10, 224, 54, 12);
		label_1.setText("Password");
		
		text_1 = new Text(c, SWT.PASSWORD|SWT.BORDER);
		text_1.setBounds(91, 221, 264, 18);
		
		label_2 = new Label(c, SWT.NONE);
		label_2.setBounds(10, 314, 54, 12);
		label_2.setText("连接成功");
		label_2.setVisible(false);
		
		
		btnLoacl = new Button(c, SWT.RADIO);
		btnLoacl.setBounds(99, 22, 93, 16);
		btnLoacl.setText("Local");
		btnLoacl.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				label.setText("UserName:");
				text.setText("");//用户名
				text_1.setText("");//密码
				if(label_2.getVisible()){
					label_2.setVisible(false);
				}
			}
		});
		
		btnRemote = new Button(c, SWT.RADIO);
		btnRemote.setBounds(232, 22, 93, 16);
		btnRemote.setText("Remote");
		btnRemote.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				label.setText("Email:");
				text.setText("");
				text_1.setText("");
				if(label_2.getVisible()){
					label_2.setVisible(false);
				}
			}
		});
		
		
		Button button = new Button(c, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(text.getText().equals("siteviewgenietest@gmail.com")&&text_1.getText().equals("siteview")){
					if(label_2.getVisible()){
						label_2.setVisible(false);
					}
//					URL url;
//					try {
//						url = new URL("https://genie.netgear.com/fcp/authenticate");
//						URLConnection connection = url.openConnection();
//						HttpURLConnection httpConn = (HttpURLConnection) connection;
//						httpConn.setDoOutput(true);
//						httpConn.setDoInput(true);
//						PrintWriter ouputstream = new PrintWriter(httpConn.getOutputStream());
//					    String body = "<authenticate type=\"basic\" username=\"siteviewgenietest@gmail.com\" password=\"siteview\"/>";
//					    ouputstream.write(body);
//					    ouputstream.flush();
//					    httpConn.connect();
//					    InputStream inputstream= httpConn.getInputStream();
//					    byte[] b = new byte[1024*100];
//					    int len=0;
//					    int temp=0;
//					    while((temp=inputstream.read())!=-1){
//					    	b[len] = (byte)temp;
//					    	len++;
//					    }
//					    System.out.println(new String(b,0,len));
//					} catch (MalformedURLException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					} catch (IOException e2) {
//						// TODO Auto-generated catch block
//						e2.printStackTrace();
//					}
					String a="authenticate";
					Map<String,String> map = new HashMap<String,String>();
					map.put("type", "basic");
					map.put("username", "siteviewgenietest@gmail.com");
					map.put("password", "siteview");
					SOAPClient4XG.connection(a, map);
					label_2.setVisible(true);
				}else if(text.getText().equals("admin")&&text_1.getText().equals("password")){
					if(label_2.getVisible()){
						label_2.setVisible(false);
					}
					label_2.setVisible(true);
				}else{
					if(label_2.getVisible()){
						label_2.setVisible(false);
					}
					MessageDialog.openInformation(null, "提示", "用户名和密码不匹配,请重新输入!");
					text.setText("");
					text_1.setText("");
				}
			}
		});
		button.setBounds(271, 285,90, 22);
		button.setText("测试连接");
		if(System.getProperty("UserName11")!=null){
			text.setText(System.getProperty("UserName"));
		}
		if(System.getProperty("Password11")!=null){
			text_1.setText(System.getProperty("Password1"));
		}
		if(System.getProperty("CallTepy")!=null){
			if(System.getProperty("CallTepy").equals("Local")){
				btnLoacl.setSelection(true);
				label.setText("UserName:");
			}else{
				btnRemote.setSelection(true);
				label.setText("Email:");
			}
		}else{
			btnLoacl.setSelection(true);
		}
		
		return c;
	}
	
	@Override
	protected void performApply() {
		
		String s=text.getText();
		String s1=text_1.getText();
		System.setProperty("UserName11",s);
		System.setProperty("Password11",s1);
		if(btnLoacl.getSelection()){
			System.setProperty("CallTepy","Local");
		}else{
			System.setProperty("CallTepy","Remote");
		}
		super.performApply();
		
	}
}
