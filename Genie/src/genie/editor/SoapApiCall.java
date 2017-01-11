package genie.editor;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import genie.MethodCall.SOAPClient4XG;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Combo;


public class SoapApiCall extends EditorPart {
	public static String readText;
	public Label lblLocal;
	public static TreeItem treeitem;
	public static TreeItem item1;
	public static TreeItem item2;
	public static TreeItem item3;
	public static TreeItem item4;
	public static TreeItem item5;
	public static TreeItem item6;
	public static TreeItem item7;
	public static TreeItem item8;
	public static final String ID = "Genie.SoapApiCall";
	private Text text;//MethodName
	Group grpCall;
	private Text text_1;// Arguments
	private Text text_2;//Result
	private Text text_3;//Example
	private Text text_5;//Input params
	private Text text_6;//ModelType
	Combo combo;//ModleName
	Label label;
	String key;
	String value;
	String result;
	String name;
	String model;
	Tree tree;
	public static Color color = new Color(null, 255, 255, 255);
	private static List list = new ArrayList<String>();
	private static Map map1 = new HashMap<String, String>();
	private static Map map2 = new HashMap<String, String>();
	private static Map map3 = new HashMap<String, String>();
	private static Map map4 = new HashMap<String, String>();
	private static Map map5 = new HashMap<String, String>();
	private static Map map6 = new HashMap<String, String>();
	private static Map map7 = new HashMap<String, String>();
	private static Map map8 = new HashMap<String, String>();
	static {
		map1.put("ConfigurationStarted",
				"urn:NETGEAR-ROUTER:service:DeviceConfig:1#ConfigurationStarted");
		map1.put("ConfigurationFinished",
				"urn:NETGEAR-ROUTER:service:DeviceConfig:1#ConfigurationFinished");
		map1.put("IsDLNASupported",
				"urn:NETGEAR-ROUTER:service:DeviceConfig:1#IsDLNASupported");
		map1.put("IsDLNAEnabled",
				"urn:NETGEAR-ROUTER:service:DeviceConfig:1#IsDLNAEnabled");
		map1.put("SetDLNAStatus",
				"urn:NETGEAR-ROUTER:service:DeviceConfig:1#SetDLNAStatus");
		map1.put("SetEnable",
				"urn:NETGEAR-ROUTER:service:DeviceConfig:1#SetEnable");
		map1.put("SetGUILanguage",
				"urn:NETGEAR-ROUTER:service:DeviceConfig:1#SetGUILanguage");
		map1.put("SetConfiguration",
				"urn:NETGEAR-ROUTER:service:DeviceConfig:1#SetConfiguration");
		map1.put("Loaddefault",
				"urn:NETGEAR-ROUTER:service:DeviceConfig:1#Loaddefault");
		map1.put("SetFirmware",
				"urn:NETGEAR-ROUTER:service:DeviceConfig:1#SetFirmware");
		map1.put("SetBlockSiteEnable",
				"urn:NETGEAR-ROUTER:service:DeviceConfig:1#SetBlockSiteEnable");
		map1.put("SetBlockSiteName",
				"urn:NETGEAR-ROUTER:service:DeviceConfig:1#SetBlockSiteName");
		map1.put("GetBlockSiteInfo",
				"urn:NETGEAR-ROUTER:service:DeviceConfig:1#GetBlockSiteInfo");
		map1.put("SetTimeZone", 
				"urn:NETGEAR-ROUTER:service:DeviceConfig:1#SetTimeZone");
		map1.put("SetTrafficMeterOptions",
				"urn:NETGEAR-ROUTER:service:DeviceConfig:1#SetTrafficMeterOptions");
		map1.put("GetTrafficMeterOptions",
				"urn:NETGEAR-ROUTER:service:DeviceConfig:1#GetTrafficMeterOptions");
		map1.put("GetTrafficMeterStatistics",
				"urn:NETGEAR-ROUTER:service:DeviceConfig:1#GetTrafficMeterStatistics");
		map1.put("GetTimeZoneInfo",
				"urn:NETGEAR-ROUTER:service:DeviceConfig:1#GetTimeZoneInfo");
		map1.put("GetInfo",
				"urn:NETGEAR-ROUTER:service:DeviceConfig:1#GetInfo");
		map1.put("GetTrafficMeterEnabled",
				"urn:NETGEAR-ROUTER:service:DeviceConfig:1#GetTrafficMeterEnabled");
		map1.put("EnableTrafficMeter",
				"urn:NETGEAR-ROUTER:service:DeviceConfig:1#EnableTrafficMeter");
		map1.put("Reboot",
				"urn:NETGEAR-ROUTER:service:DeviceConfig:1#Reboot");
		map1.put("CheckNewFirmware",
				"urn:NETGEAR-ROUTER:service:DeviceConfig:1#CheckNewFirmware");
		map1.put("UpdateNewFirmware",
				"urn:NETGEAR-ROUTER:service:DeviceConfig:1#UpdateNewFirmware");
		map1.put("ResetToFactoryDefault",
				"urn:NETGEAR-ROUTER:service:DeviceConfig:1#ResetToFactoryDefault");
		
		
		map2.put("GetAttachDevice","urn:NETGEAR-ROUTER:service:DeviceInfo:1#GetAttachDevice");
		map2.put("GetSysUpTime","urn:NETGEAR-ROUTER:service:DeviceInfo:1#GetSysUpTime");
		map2.put("GetInfo","urn:NETGEAR-ROUTER:service:DeviceInfo:1#GetInfo");
		
		
		map3.put("SetIPInterfaceInfo",
				"urn:NETGEAR-ROUTER:service:WANIPConnection:1#SetIPInterfaceInfo");
		map3.put("SetSmartWizardDetection",
				"urn:NETGEAR-ROUTER:service:WANIPConnection:1#SetSmartWizardDetection");
		map3.put("SetDSLConfig",
				"urn:NETGEAR-ROUTER:service:WANIPConnection:1#SetDSLConfig");
		map3.put("GetPPPConnStatus",
				"urn:NETGEAR-ROUTER:service:WANIPConnection:1#GetPPPConnStatus");
		map3.put("GetConnectionTypeInfo",
				"urn:NETGEAR-ROUTER:service:WANIPConnection:1#GetConnectionTypeInfo");
		map3.put("GetModemInfo",
				"urn:NETGEAR-ROUTER:service:WANIPConnection:1#GetModemInfo");
		map3.put("GetDNSLookUpStatus",
				"urn:NETGEAR-ROUTER:service:WANIPConnection:1#GetDNSLookUpStatus");
		map3.put("GetPortMappingInfo",
				"urn:NETGEAR-ROUTER:service:WANIPConnection:1#GetPortMappingInfo");
		map3.put("SetConnectionType",
				"urn:NETGEAR-ROUTER:service:WANIPConnection:1#SetConnectionType");
		map3.put("SetMACAddress",
				"urn:NETGEAR-ROUTER:service:WANIPConnection:1#SetMACAddress");
		map3.put("SetMaxMTUSize",
				"urn:NETGEAR-ROUTER:service:WANIPConnection:1#SetMaxMTUSize");
		map3.put("AddPortMapping",
				"urn:NETGEAR-ROUTER:service:WANIPConnection:1#AddPortMapping");
		map3.put("DeletePortMapping",
				"urn:NETGEAR-ROUTER:service:WANIPConnection:1#DeletePortMapping");
		map3.put("GetInfo",
				"urn:NETGEAR-ROUTER:service:WANIPConnection:1#GetInfo");
		
		
		
		map4.put("SetConnectionType","urn:NETGEAR-ROUTER:service:WAN3GInterfaceConfig:1#SetConnectionType");
		map4.put("Set3GConfig","urn:NETGEAR-ROUTER:service:WAN3GInterfaceConfig:1#Set3GConfig");
		map4.put("GetInfo","urn:NETGEAR-ROUTER:service:WAN3GInterfaceConfig:1#GetInfo");
		map4.put("Get3GInfo","urn:NETGEAR-ROUTER:service:WAN3GInterfaceConfig:1#Get3GInfo");
		
		
		map5.put("GetEthernetLinkStatus",
				"urn:NETGEAR-ROUTER:service:WANEthernetLinkConfig:1#GetEthernetLinkStatus");
		map5.put("SetWANRelease",
				"urn:NETGEAR-ROUTER:service:WANEthernetLinkConfig:1#SetWANRelease");
		map5.put("SetWANRenew",
				"urn:NETGEAR-ROUTER:service:WANEthernetLinkConfig:1#SetWANRenew");
		
		
		map6.put("SetConfigLANSubnet",
				"urn:NETGEAR-ROUTER:service:LANConfigSecurity:1#SetConfigLANSubnet");
		map6.put("SetConfigLANIP",
				"urn:NETGEAR-ROUTER:service:LANConfigSecurity:1#SetConfigLANIP");
		map6.put("SetConfigLAN",
				"urn:NETGEAR-ROUTER:service:LANConfigSecurity:1#SetConfigLAN");
		map6.put("SetConfigDHCPEnable",
				"urn:NETGEAR-ROUTER:service:LANConfigSecurity:1#SetConfigDHCPEnable");
		map6.put("SetConfigPassword",
				"urn:NETGEAR-ROUTER:service:LANConfigSecurity:1#SetConfigPassword");
		map6.put("GetInfo", 
				 "urn:NETGEAR-ROUTER:service:LANConfigSecurity:1#GetInfo");
		
		
		
		
		map7.put("GetWLANInfo",
				"urn:NETGEAR-ROUTER:service:WLANConfiguration:1#GetWLANInfo");
		map7.put("GetWEPSecurityKeys",
				"urn:NETGEAR-ROUTER:service:WLANConfiguration:1#GetWEPSecurityKeys");
		map7.put("GetWPASecurityKeys",
				"urn:NETGEAR-ROUTER:service:WLANConfiguration:1#GetWPASecurityKeys");
		map7.put("GetInfo",
				"urn:NETGEAR-ROUTER:service:WLANConfiguration:1#GetInfo");
		map7.put("GetWPSMode",
				"urn:NETGEAR-ROUTER:service:WLANConfiguration:1#GetWPSMode");
		map7.put("GetSSID",
				"urn:NETGEAR-ROUTER:service:WLANConfiguration:1#GetSSID");
		map7.put("GetChannelInfo",
				"urn:NETGEAR-ROUTER:service:WLANConfiguration:1#GetChannelInfo");
		map7.put("Get5GChannelInfo",
				"urn:NETGEAR-ROUTER:service:WLANConfiguration:1#Get5GChannelInfo");
		map7.put("GetSSIDBroadcast",
				"urn:NETGEAR-ROUTER:service:WLANConfiguration:1#GetSSIDBroadcast");
		map7.put("SetEnable",
				 "urn:NETGEAR-ROUTER:service:WLANConfiguration:1#SetEnable");
		map7.put("SetChannel",
				 "urn:NETGEAR-ROUTER:service:WLANConfiguration:1#SetChannel");
		map7.put("Set5GChannel",
				 "urn:NETGEAR-ROUTER:service:WLANConfiguration:1#Set5GChannel");
		map7.put("SetSSID",
				 "urn:NETGEAR-ROUTER:service:WLANConfiguration:1#SetSSID");
		map7.put("SetSSIDBroadcast",
				 "urn:NETGEAR-ROUTER:service:WLANConfiguration:1#SetSSIDBroadcast");
		map7.put("SetWLANWPAPSKByPassphrase",
				"urn:NETGEAR-ROUTER:service:WLANConfiguration:1#SetWLANWPAPSKByPassphrase");
		map7.put("SetWLANNoSecurity",
				"urn:NETGEAR-ROUTER:service:WLANConfiguration:1#SetWLANNoSecurity");
		map7.put("SetWLANWEPByKeys",
				"urn:NETGEAR-ROUTER:service:WLANConfiguration:1#SetWLANWEPByKeys");
		map7.put("SetWLANWEPByPassphrase",
				"urn:NETGEAR-ROUTER:service:WLANConfiguration:1#SetWLANWEPByPassphrase");
		map7.put("SetWPSMode",
				"urn:NETGEAR-ROUTER:service:WLANConfiguration:1#SetWPSMode");
		map7.put("SetConfigPassword",
				"urn:NETGEAR-ROUTER:service:WLANConfiguration:1#SetConfigPassword");
		
		
		
		map8.put("Authenticate",
				"urn:NETGEAR-ROUTER:service:ParentalControl:1#Authenticate");
		map8.put("GetEnableStatus",
				"urn:NETGEAR-ROUTER:service:ParentalControl:1#GetEnableStatus");
		map8.put("DeleteMACAddress",
				"urn:NETGEAR-ROUTER:service:ParentalControl:1#DeleteMACAddress");
		map8.put("EnableParentalControl",
				"urn:NETGEAR-ROUTER:service:ParentalControl:1#EnableParentalControl");
		map8.put("GetAllMACAddresses",
				"urn:NETGEAR-ROUTER:service:ParentalControl:1#GetAllMACAddresses");
		

	}

	public SoapApiCall() {

	}

	@Override
	public void doSave(IProgressMonitor monitor) {

	}

	@Override
	public void doSaveAs() {

	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {

		this.setInput(input);
		this.setSite(site);
		this.setPartName(input.getName());
	}

	@Override
	public boolean isDirty() {

		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {

		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		FillLayout fl_parent = new FillLayout();
		fl_parent.type = SWT.VERTICAL;
		parent.setLayout(fl_parent);

		SashForm sashForm = new SashForm(parent, SWT.VERTICAL);
		sashForm.setBackground(color);
		lblLocal = new Label(sashForm, SWT.CENTER);
		lblLocal.setFont(SWTResourceManager.getFont("宋体", 16, SWT.NORMAL));
		lblLocal.setText("Remote");
		lblLocal.setBackground(color);

		Composite composite = new Composite(sashForm, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		SashForm sashForm_1 = new SashForm(composite, SWT.NONE);
		composite.setBackground(color);

		Group grpMethodname = new Group(sashForm_1, SWT.NONE);
		grpMethodname.setText("MethodName");
		grpMethodname.setLayout(new FillLayout(SWT.HORIZONTAL));
		grpMethodname.setBackground(color);
		tree = new Tree(grpMethodname, SWT.BORDER);
		if (list.size() == 0) {
			list.add("DeviceConfig");
			list.add("DeviceInfo");
			list.add("WANIPConnection");
			list.add("WAN3GInterfaceConfig");
			list.add("WANEthernetLinkConfig");
			list.add("LANConfigSecurity");
			list.add("WLANConfiguration");
			list.add("ParentalControl");
		}
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			String element = (String) iter.next();
			treeitem = new TreeItem(tree, SWT.NONE);
			treeitem.setData(element);
			treeitem.setText(element);
			if (treeitem.getText().equals("DeviceConfig")) {
				Set set1 = map1.keySet();
				for (Iterator it = set1.iterator(); it.hasNext();) {
					String element1 = (String) it.next();
					item1 = new TreeItem(treeitem, SWT.NONE);
					item1.setData(element1);
					item1.setText(element1);
				}
			} else if (treeitem.getText().equals("DeviceInfo")) {
				Set set2 = map2.keySet();
				for (Iterator it = set2.iterator(); it.hasNext();) {
					String element2 = (String) it.next();
					item2 = new TreeItem(treeitem, SWT.NONE);
					item2.setData(element2);
					item2.setText(element2);
				}
			} else if (treeitem.getText().equals("WANIPConnection")) {
				Set set3 = map3.keySet();
				for (Iterator it = set3.iterator(); it.hasNext();) {
					String element3 = (String) it.next();
					item3 = new TreeItem(treeitem, SWT.NONE);
					item3.setData(element3);
					item3.setText(element3);
				}
			} else if (treeitem.getText().equals("WAN3GInterfaceConfig")) {
				Set set4 = map4.keySet();
				for (Iterator it = set4.iterator(); it.hasNext();) {
					String element4 = (String) it.next();
					item4 = new TreeItem(treeitem, SWT.NONE);
					item4.setData(element4);
					item4.setText(element4);
				}
			} else if (treeitem.getText().equals("WANEthernetLinkConfig")) {
				Set set5 = map5.keySet();
				for (Iterator it = set5.iterator(); it.hasNext();) {
					String element5 = (String) it.next();
					item5 = new TreeItem(treeitem, SWT.NONE);
					item5.setData(element5);
					item5.setText(element5);
				}
			} else if (treeitem.getText().equals("LANConfigSecurity")) {
				Set set6 = map6.keySet();
				for (Iterator it = set6.iterator(); it.hasNext();) {
					String element6 = (String) it.next();
					item6 = new TreeItem(treeitem, SWT.NONE);
					item6.setData(element6);
					item6.setText(element6);
				}
			} else if (treeitem.getText().equals("WLANConfiguration")) {
				Set set7 = map7.keySet();
				for (Iterator it = set7.iterator(); it.hasNext();) {
					String element7 = (String) it.next();
					item7 = new TreeItem(treeitem, SWT.NONE);
					item7.setData(element7);
					item7.setText(element7);
				}
			} else if (treeitem.getText().equals("ParentalControl")) {
				Set set8 = map8.keySet();
				for (Iterator it = set8.iterator(); it.hasNext();) {
					String element8 = (String) it.next();
					item8 = new TreeItem(treeitem, SWT.NONE);
					item8.setData(element8);
					item8.setText(element8);
				}
			}

		}
		tree.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				String s = (String) e.item.getData();
				TreeItem treeItem=(TreeItem)e.item;
				if(s.equals("DeviceConfig")||s.equals("DeviceInfo")
				 ||s.equals("WANIPConnection")||s.equals("WAN3GInterfaceConfig")
				 ||s.equals("WANEthernetLinkConfig")||s.equals("LANConfigSecurity")
				 ||s.equals("WLANConfiguration")||s.equals("ParentalControl")){
					text.setText("");// MethodName
					text_1.setText("");// Arguments
					text_2.setText("");// Result
					combo.setText("");//ModleName
				}else if(treeItem.getParentItem().getText().equals("DeviceConfig")){
					text.setText(s);// MethodName
					text_1.setText(map1.get(s).toString());// Arguments
					text_2.setText("");// Result
					combo.setText(treeItem.getParentItem().getText());//ModleName
				}else if(treeItem.getParentItem().getText().equals("DeviceInfo")){
					text.setText(s);// MethodName
					text_1.setText(map2.get(s).toString());// Arguments
					text_2.setText("");// Result
					combo.setText(treeItem.getParentItem().getText());//ModleName
				}else if(treeItem.getParentItem().getText().equals("WANIPConnection")){
					text.setText(s);// MethodName
					text_1.setText(map3.get(s).toString());// Arguments
					text_2.setText("");// Result
					combo.setText(treeItem.getParentItem().getText());//ModleName
				}else if(treeItem.getParentItem().getText().equals("WAN3GInterfaceConfig")){
					text.setText(s);// MethodName
					text_1.setText(map4.get(s).toString());// Arguments
					text_2.setText("");// Result
					combo.setText(treeItem.getParentItem().getText());//ModleName
				}else if(treeItem.getParentItem().getText().equals("WANEthernetLinkConfig")){
					text.setText(s);// MethodName
					text_1.setText(map5.get(s).toString());// Arguments
					text_2.setText("");// Result
					combo.setText(treeItem.getParentItem().getText());//ModleName
				}else if(treeItem.getParentItem().getText().equals("LANConfigSecurity")){
					text.setText(s);// MethodName
					text_1.setText(map6.get(s).toString());// Arguments
					text_2.setText("");// Result
					combo.setText(treeItem.getParentItem().getText());//ModleName
				}else if(treeItem.getParentItem().getText().equals("WLANConfiguration")){
					text.setText(s);// MethodName
					text_1.setText(map7.get(s).toString());// Arguments
					text_2.setText("");// Result
					combo.setText(treeItem.getParentItem().getText());//ModleName
				}else if(treeItem.getParentItem().getText().equals("ParentalControl")){
					text.setText(s);// MethodName
					text_1.setText(map8.get(s).toString());// Arguments
					text_2.setText("");// Result
					combo.setText(treeItem.getParentItem().getText());//ModleName
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		sashForm_1.setBackground(color);
		grpCall = new Group(sashForm_1, SWT.NONE);
		grpCall.setText("Call");
		grpCall.setBackground(color);

		Label lblMethodname = new Label(grpCall, SWT.NONE);//MethodName
		lblMethodname.setBounds(10, 32, 79, 12);
		lblMethodname.setText("MethodName");
		lblMethodname.setBackground(color);
		text = new Text(grpCall, SWT.BORDER);
		text.setBounds(95, 26, 220, 18);
		text.setBackground(color);
		
		Label lblModleName = new Label(grpCall, SWT.NONE);//ModleName
		lblModleName.setBounds(10, 68, 79, 12);
		lblModleName.setText("ModleName");
		lblModleName.setBackground(color); 
		combo = new Combo(grpCall, SWT.BORDER);
		combo.setBounds(95, 65, 220, 20);
		combo.setBackground(color);
//		combo.add("other");
		combo.add("DeviceConfig");
		combo.add("DeviceInfo");
		combo.add("LANConfigSecurity");
		combo.add("ParentalControl");
		combo.add("Time");
		combo.add("WANEthernetLinkConfig");
		combo.add("WANIPConnection");
		combo.add("WLANConfiguration");
		combo.add("WAN3GInterfaceConfig");
        combo.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				if( combo.getText().equals("DeviceConfig")||combo.getText().equals("DeviceInfo")
						||combo.getText().equals("LANConfigSecurity")||combo.getText().equals("ParentalControl")
						||combo.getText().equals("Time")||combo.getText().equals("WANEthernetLinkConfig")
						||combo.getText().equals("WANIPConnection")||combo.getText().equals("WLANConfiguration")
						||combo.getText().equals("WAN3GInterfaceConfig")){
					
					text_1.setText("");
					text_1.setText("urn:NETGEAR-ROUTER:service:"+combo.getText()+":1#"+text.getText());// Arguments
				}
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Label lblparams = new Label(grpCall, SWT.NONE);//Input params
		lblparams.setBounds(10, 104, 79, 12);
		lblparams.setText("Input params");
		lblparams.setBackground(color); 
		text_5 = new Text(grpCall, SWT.BORDER | SWT.WRAP|SWT.V_SCROLL);
		text_5.setBounds(95, 104, 220, 90);
		text_5.setBackground(color);
		
		label = new Label(grpCall, SWT.NONE);//ModelType
		label.setBounds(10, 210, 79, 12);
		label.setText("ModelType");
		label.setBackground(color);
		text_6 = new Text(grpCall, SWT.BORDER);
		text_6.setBounds(95, 213, 220, 20);
		text_6.setBackground(color);

		
		Label lblArguments = new Label(grpCall, SWT.NONE);//Arguments
		lblArguments.setBounds(10, 305, 79, 12);
		lblArguments.setText("Arguments");
		lblArguments.setBackground(color);
		text_1 = new Text(grpCall, SWT.BORDER | SWT.WRAP);
		text_1.setEditable(false);
		text_1.setBounds(95, 258, 306, 223);
		text_1.setBackground(color);
		
		
		Label lblResult = new Label(grpCall, SWT.NONE);//Result
		lblResult.setText("Result");
		lblResult.setBounds(421, 215, 54, 12);
		lblResult.setBackground(color);
		text_2 = new Text(grpCall, SWT.BORDER | SWT.WRAP|SWT.V_SCROLL);
		text_2.setBounds(487, 25, 300, 406);
		text_2.setEditable(false);
		text_2.setBackground(color);
		
		
	    Button button = new Button(grpCall, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {// 调用按钮的事件
			public void widgetSelected(SelectionEvent e) {
//				if(!(text_5.getText().equals(""))){
//					String id = "";
//					StringBuffer fcml4=new StringBuffer();
//					String []keyandvalue=text_5.getText().split(";");
//					fcml4.append("<fcml to=\"netrouter@cp82195\" from=\"" + name
//							+ "@portal\" _tracer=\"10\"><" + combo.getText()
//							+ "." + text.getText() + " _sessionId=\"" + id
//							+ "\""+" ");
//					for (int i = 0; i < keyandvalue.length; i++) {
//						String key=keyandvalue[i].split(",")[0];
//						System.out.println("Key:"+key);
//						String value=keyandvalue[i].split(",")[1];
//						System.out.println("value:"+value);
//						if(i==keyandvalue.length-1){
//							fcml4.append(key+"="+"\""+value+"\""); 
//						}else{
//							fcml4.append(key+"="+"\""+value+"\""+" "); 
//						}
//					}
//					fcml4.append("/></fcml>");
//					System.out.println(fcml4);
//				}else {
//				String id = "";	
//				String	fcml4 = "<fcml to=\"netrouter@cp82195\" from=\"" + name
//							+ "@portal\" _tracer=\"10\"><" + combo.getText()
//							+ "." + text.getText() + " _sessionId=\"" + id
//							+ "\"/></fcml>";
//				System.out.println(fcml4);
//				}
				
				
				
				String sessionId = "";
				String jsessionId = "";
				String DeviceConfig = "";
				String id = "";
					// 第一次发送请求获得sessionId
					Map<String, String> map = new HashMap<String, String>();
					map.put("init", "<init type=\"ui\" fcmb=\"true\"/>");
					Set set = map.keySet();
					for (Iterator it = set.iterator(); it.hasNext();) {
						key = (String) it.next();
						value = map.get(key);
						result = SOAPClient4XG.remoteRun(key, value);
						System.out.println("第一次返回的结果:" + result);
						if (!(result.equals(""))
								&& !(result
										.equals("<authenticate result=\"401\" description=\"Unauthorized\"/>"))) {
							String str = result.substring(0,
									result.lastIndexOf(">") + 1);
							sessionId = result.substring(result
									.lastIndexOf(">") + 1);
							System.out.println("第一次返回结果中的sessionId"+sessionId);//JSESSIONID=fae21548a82f5e866f25dd385a8c;

							sessionId.substring(0,
									sessionId.lastIndexOf("=") + 1);
							jsessionId = sessionId.substring(sessionId
									.lastIndexOf("=") + 1);//fae21548a82f5e866f25dd385a8c;

							String[] a = jsessionId.split(";");
							DeviceConfig = a[0];
							System.out.println("DeviceConfig"+DeviceConfig);//fae21548a82f5e866f25dd385a8c
							text_2.setText(str);
						}
					}

					// 第二次发送请求
					if (!(result.equals(""))
							&& !(result
									.equals("<authenticate result=\"401\" description=\"Unauthorized\"/>"))) {
						String str = result.substring(result.indexOf("name=") + 5);
						name = str.substring(str.indexOf('"') + 1,
								str.indexOf('"', 1));
					}
					String a = "send?n=" + name;
					String fcml = "<fcml to=\"router@portal\" from=\"" + name
							+ "@portal\" _tracer=\"8\"><get/></fcml>";
					result = SOAPClient4XG.RemoteConnectionRun(sessionId, a, fcml);
					if (result.equals("")) {
						result = "200 ok";
					}
					System.out.println("第二次返回的结果:" + result);
					text_2.setText(result);

					// 第三次发送请求并获取model以及model的序列号
					String a1 = "receive?n=" + name;
					String fcml1 = "<DeviceConfig.ConfigurationStarted=\""
							+ DeviceConfig + "\"/>";
					result = SOAPClient4XG.RemoteConnectionRun(sessionId, a1, fcml1);
					System.out.println("第三次返回的结果:" + result);
					if (!(result.equals(""))
							&& !(result
									.equals("<authenticate result=\"401\" description=\"Unauthorized\"/>"))) {
						String str = result.substring(result.indexOf("model=") + 6);
						model = str.substring(str.indexOf('"') + 1,
								str.indexOf('"', 1));
						String string = result.substring(result
								.indexOf("serial=") + 7);
						String number = string.substring(
								string.indexOf('"') + 1, string.indexOf('"', 1));
						System.out.println("model型号:" + model);
						System.out.println("model序列号:" + number);//序列号:2P21177F0008A
						if (model != null) {
							text_6.setText(model);
						}
						text_2.setText(result);
					}

					// 第四次发送请求
					String a2 = "send?n=" + name;
					String fcml2 = "<fcml to=\"netrouter@cp82195\" from=\""
							+ name
							+ "@portal\" _tracer=\"9\"><SessionManagement.startSession username=\"admin\" password=\"password\"/></fcml>";
					result = SOAPClient4XG.RemoteConnectionRun(sessionId, a2, fcml2);
					if (result.equals("")) {
						result = "200 ok";
					}
					text_2.setText(result);
					System.out.println("第四次返回的结果:" + result);

					// 第五次发送请求并且得到之后都要用到的id
					String a3 = "receive?n=" + name;
					String fcml3 = "<DeviceConfig.ConfigurationStarted=\""
							+ DeviceConfig + "\"/>";
					result = SOAPClient4XG.RemoteConnectionRun(sessionId, a3, fcml3);
					System.out.println("第五次返回结果:" + result);
					if (!(result.equals(""))
							&& !(result
									.equals("<authenticate result=\"401\" description=\"Unauthorized\"/>"))) {
						text_2.setText(result);
						String str1 = result.substring(result
								.indexOf("sessionId=") + 10);
						id = str1.substring(str1.indexOf('"') + 1,
								str1.indexOf('"', 1));
						 System.out.println("id:"+id);
					}

					// 第六次发送请求
					String a4 = "send?n=" + name;
					StringBuffer fcml4=new StringBuffer();
				 // String fcml4="<fcml to=\"netrouter@cp82195\" from=\""+name+"@portal\" _tracer=\"10\"><WLANConfiguration.GetInfo _sessionId=\""+id+"\"/></fcml>";
					if(!(text_5.getText().equals(""))){
						String []keyandvalue=text_5.getText().split(";");
						fcml4.append("<fcml to=\"netrouter@cp82195\" from=\"" + name
								+ "@portal\" _tracer=\"10\"><" + combo.getText()
								+ "." + text.getText() + " _sessionId=\"" + id
								+ "\""+" ");
						for (int i = 0; i < keyandvalue.length; i++) {
							String key=keyandvalue[i].split(",")[0];
							System.out.println("Key:"+key);
							String value=keyandvalue[i].split(",")[1];
							System.out.println("value:"+value);
							if(i==keyandvalue.length-1){
								fcml4.append(key+"="+"\""+value+"\""); 
							}else{
								fcml4.append(key+"="+"\""+value+"\""+" "); 
							}
						}
						fcml4.append("/></fcml>");
						System.out.println("fcml4:"+fcml4);
					}else {
					fcml4.append("<fcml to=\"netrouter@cp82195\" from=\"" + name
							+ "@portal\" _tracer=\"10\"><" + combo.getText()
							+ "." + text.getText() + " _sessionId=\"" + id
							+ "\"/></fcml>");
					    System.out.println("fcml4:"+fcml4);
					}
					String fc4=fcml4.toString();
					result = SOAPClient4XG.RemoteConnectionRun(sessionId, a4, fc4);
					if (result.equals("")) {
						result = "200 ok";
					}
					System.out.println("第六次返回结果:" + result);
					text_2.setText(result);

					// 第七次发送请求
					String a5 = "receive?n=" + name;
					String fcml5 = "<DeviceConfig.ConfigurationStarted=\""
							+ DeviceConfig + "\"/>";
					result = SOAPClient4XG.RemoteConnectionRun(sessionId, a5, fcml5);
					System.out.println("第七次返回结果:" + result);
					if (!(result.equals(""))
							&& !(result
									.equals("<authenticate result=\"401\" description=\"Unauthorized\"/>"))) {
						text_2.setText(result);
					}

			}
		});
		button.setBounds(95, 510, 72, 22);
		button.setText("\u8C03\u7528");
		
	    Button but = new Button(grpCall, SWT.NONE);
	    but.addSelectionListener(new SelectionListener() {//复制代码按钮事件
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				String temp1=text_3.getText();
				StringSelection ss = new StringSelection(temp1);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
				
				getClipboardText();
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		but.setBounds(170, 510, 72, 22);
		but.setText("复制");
		
 
		Label lab = new Label(grpCall, SWT.NONE);//Example
		lab.setBounds(10, 605, 85, 12);
		lab.setText("Example");
		lab.setBackground(color);
		text_3 = new Text(grpCall, SWT.BORDER | SWT.WRAP|SWT.V_SCROLL);
		text_3.setBounds(95, 560, 680, 140);
		text_3.setEditable(false);
		text_3.setText("public static String remoteRun(String a,String fcml){//请求远程认证获得sessionId为进行数据交互即会话做准备(其中a表示所传入的地址fcml表示发送的请求内容)\n"+
		                   "URL url;\n"+
					       "String string=null;\n"+
		                   "String sessionId=null;\n"+
					       "try {\n"+
		                   "url = new URL(https://genie.netgear.com/fcp/authenticate);\n"+
					       "URLConnection connection = url.openConnection();\n"+
		                   "HttpURLConnection httpConn = (HttpURLConnection) connection;\n"+
					       "httpConn.setDoOutput(true);\n"+
		                   "httpConn.setDoInput(true);\n"+
					       "PrintWriter ouputstream = new PrintWriter(httpConn.getOutputStream());\n"+
		                   "String body = <authenticate type=\"basic\" username=\"siteviewgenietest@gmail.com\" password=\"siteview\"/>;\n"+
					       "ouputstream.write(body);\n"+
		                   "ouputstream.flush();\n"+
					       "httpConn.connect();\n"+
		                   "String cookieVal = null;\n"+
					       "String key=null;\n"+
		                   "for (int i = 1; (key = httpConn.getHeaderFieldKey(i)) != null; i++ ) {\n"+
					       "if (key.equalsIgnoreCase(set-cookie)) {\n"+
		                   "cookieVal = httpConn.getHeaderField(i);\n"+
					       "cookieVal = cookieVal.substring(0, cookieVal.indexOf(;));\n"+
		                   "sessionId=sessionId+cookieVal+;;\n"+
					       "}\n"+
		                   "}\n"+
					       "if(sessionId!=null){\n"+
		                   "string = connectionRun(sessionId, a, fcml);\n"+
					       "}\n"+
		                   "InputStream inputstream= httpConn.getInputStream();\n"+
					       "byte[] b = new byte[1024*100];\n"+
		                   "int len=0;\n"+
					       "int temp=0;\n"+
		                   "while((temp=inputstream.read())!=-1){\n"+
					       "b[len] = (byte)temp;\n"+
		                   "len++;\n"+
					       "}\n"+
		                   "return string+sessionId;\n"+
					       "} catch (MalformedURLException e1) {\n"+
		                   "e1.printStackTrace();\n"+
					       "} catch (IOException e2) {\n"+
		                   "e2.printStackTrace();\n"+
					       "}\n"+
		                   "return null;\n"+
					       "}\n"+
		                   "\n"+
		                   "public static String connectionRun(String sessionId,String a,String fcml){//获得sessionId后进行数据交互即会话\n"+
					       "URL url;\n"+
		                   "String result=null;\n"+
					       "try {\n"+
		                   "url = new URL(https://genie.netgear.com/fcp/+a);\n"+
					       "URLConnection connection = url.openConnection();\n"+
		                   "HttpURLConnection httpConn = (HttpURLConnection) connection;\n"+
					       "httpConn.setDoOutput(true);\n"+
		                   "httpConn.setDoInput(true);\n"+
					       "httpConn.setRequestProperty(Cookie, sessionId);\n"+
		                   "PrintWriter ouputstream = new PrintWriter(httpConn.getOutputStream());\n"+
					       "String body = fcml;\n"+
		                   "ouputstream.write(body);\n"+
					       "ouputstream.flush();\n"+
		                   "httpConn.connect();\n"+
					       "InputStream inputstream= httpConn.getInputStream();\n"+
		                   "byte[] b = new byte[1024*100];\n"+
					       "int len=0;\n"+
		                   "int temp=0;\n"+
					       "while((temp=inputstream.read())!=-1){\n"+
		                   "b[len] = (byte)temp;\n"+
					       "len++;\n"+
		                   "}\n"+
					       "result=new String(b,0,len);\n"+
		                   "return result;\n"+
					       "} catch (MalformedURLException e1) {\n"+
		                   "e1.printStackTrace();\n"+
					       "} catch (IOException e2) {\n"+
		                   "e2.printStackTrace();\n"+
					       "}\n"+
		                   "return null;\n"+
					       "}");


		sashForm_1.setWeights(new int[] { 116, 475 });
		sashForm.setWeights(new int[] { 1, 20 });
	}
	protected static String getClipboardText(){
		//读取剪贴板:(相当于ctrl+v)
		//获取剪切板中的内容 
		Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
		if(t!=null){
			//检查内容是否是文本类型 
			if(t.isDataFlavorSupported(DataFlavor.stringFlavor)){
				try {
					readText = (String)t.getTransferData(DataFlavor.stringFlavor);
					//System.out.println("复制的内容:"+readText);
				} catch (UnsupportedFlavorException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		return readText;
		
	}
	@Override
	public void setFocus() {
	
}
}
