package genie.editor;

import genie.MethodCall.SOAPClient4XG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.wb.swt.SWTResourceManager;

public class NetgearCall extends EditorPart {
	public static final String ID = "Genie.NetgearCall";
	public Label lblLocal;
	public static Color color=new Color(null,255,255,255);
	private Text text;//MethodName
	private Text text_1;//Arguments
	private Text text_2;//Result
	private Text text_3;//SOAPUrl
	private Text text_4;//ModleName
	private Text text_5;//input params
	private Text text_6;//other
	private Text text_7;//Instructions for use
	Tree tree;
	Group grpCall ;
	Combo combo;
	Label label;
	String s;
	String key;
	String value;
	public static TreeItem treeitem;
	public static TreeItem item1;
	public static TreeItem treeitem1;
	public static TreeItem treeitem2;
	public static TreeItem treeitem3;
	public static TreeItem treeitem4;
	public static TreeItem treeitem5;
	public static TreeItem treeitem6;
	public static TreeItem treeitem7;
	public static TreeItem treeitem8;
	private static Map map=new HashMap<String,String>();
	private static Map map1 = new HashMap<String, String>();
	private static Map map2 = new HashMap<String, String>();
	private static Map map3 = new HashMap<String, String>();
	private static Map map4 = new HashMap<String, String>();
	private static Map map5 = new HashMap<String, String>();
	private static Map map6 = new HashMap<String, String>();
	private static Map map7 = new HashMap<String, String>();
	private static Map map8 = new HashMap<String, String>();
	private static List list1 = new ArrayList<String>();
	private static List list2 = new ArrayList<String>();
	static{
		map.put("Authenticate", "urn:NETGEAR-ROUTER:service:DeviceConfig:1#Authenticate");
		map.put("GetAPInfo", "urn:NETGEAR-ROUTER:service:WLANConfiguration:1#GetAPInfo");
		map.put("SetExtenderMode", "urn:NETGEAR-ROUTER:service:WLANConfiguration:1#SetExtenderMode");
		map.put("ConfigurationStarted", "urn:NETGEAR-ROUTER:service:DeviceConfig:1#ConfigurationStarted");
		map.put("SetRouterWLANWPAPSKByPassphrase", "urn:NETGEAR-ROUTER:service:WLANConfiguration:1#SetRouterWLANWPAPSKByPassphrase");
		map.put("SetWLANWPAPSKByPassphrase", "urn:NETGEAR-ROUTER:service:WLANConfiguration:1#SetWLANWPAPSKByPassphrase");
		map.put("ConfigurationFinished", "urn:NETGEAR-ROUTER:service:DeviceConfig:1#ConfigurationFinished");
		map.put("SetEnable", "urn:NETGEAR-ROUTER:service:DeviceConfig:1#SetEnable");
		map.put("GetRouterWLANWPAInfo", "urn:NETGEAR-ROUTER:service:WLANConfiguration:1#GetRouterWLANWPAInfo");
		
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
	
	public NetgearCall() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		// TODO Auto-generated method stub
		this.setInput(input);
		this.setSite(site);
		this.setPartName(input.getName());
	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		FillLayout fl_parent = new FillLayout();
		fl_parent.type = SWT.VERTICAL;
		parent.setLayout(fl_parent);
		
		SashForm sashForm = new SashForm(parent, SWT.VERTICAL);
		sashForm.setBackground(color);
		lblLocal = new Label(sashForm, SWT.CENTER);
		lblLocal.setFont(SWTResourceManager.getFont("宋体", 16, SWT.NORMAL));
		lblLocal.setText("ExtenderAndGenieAPI(Local)");
		lblLocal.setBackground(color);
		
		Composite composite = new Composite(sashForm, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		SashForm sashForm_1=new SashForm(composite, SWT.NONE);
		composite.setBackground(color);
		
		Group grpMethodname = new Group(sashForm_1, SWT.NONE);
		grpMethodname.setText("MethodName");
		grpMethodname.setLayout(new FillLayout(SWT.HORIZONTAL));
		grpMethodname.setBackground(color);
		tree = new Tree(grpMethodname, SWT.BORDER);
		
		if (list1.size() == 0) {
			list1.add("GenieAPI(local)");
			list1.add("NetgearExtender");
		}
		
		if (list2.size() == 0) {
			list2.add("DeviceConfig");
			list2.add("DeviceInfo");
			list2.add("WANIPConnection");
			list2.add("WAN3GInterfaceConfig");
			list2.add("WANEthernetLinkConfig");
			list2.add("LANConfigSecurity");
			list2.add("WLANConfiguration");
			list2.add("ParentalControl");
		}


		for(Iterator iter=list1.iterator(); iter.hasNext();){
			String   element   =   (String)   iter.next();
			   treeitem=new TreeItem(tree, SWT.NONE);
			   treeitem.setData(element);
			   treeitem.setText(element);
			   if (treeitem.getText().equals("GenieAPI(local)")) {
					for (Iterator it = list2.iterator(); it.hasNext();) {
						String element1 = (String) it.next();
						item1 = new TreeItem(treeitem, SWT.NONE);
						item1.setData(element1);
						item1.setText(element1);
						if (item1.getText().equals("DeviceConfig")) {
							Set set1 = map1.keySet();
							for (Iterator it1 = set1.iterator(); it1.hasNext();) {
								String ele1 = (String) it1.next();
								treeitem1 = new TreeItem(item1, SWT.NONE);
								treeitem1.setData(ele1);
								treeitem1.setText(ele1);
							}
						} else if (item1.getText().equals("DeviceInfo")) {
							Set set2 = map2.keySet();
							for (Iterator it2 = set2.iterator(); it2.hasNext();) {
								String ele2 = (String) it2.next();
								treeitem2 = new TreeItem(item1, SWT.NONE);
								treeitem2.setData(ele2);
								treeitem2.setText(ele2);
							}
						} else if (item1.getText().equals("WANIPConnection")) {
							Set set3 = map3.keySet();
							for (Iterator it3 = set3.iterator(); it3.hasNext();) {
								String ele3 = (String) it3.next();
								treeitem3 = new TreeItem(item1, SWT.NONE);
								treeitem3.setData(ele3);
								treeitem3.setText(ele3);
							}
						} else if (item1.getText().equals("WAN3GInterfaceConfig")) {
							Set set4 = map4.keySet();
							for (Iterator it4 = set4.iterator(); it4.hasNext();) {
								String element4 = (String) it4.next();
								treeitem4 = new TreeItem(item1, SWT.NONE);
								treeitem4.setData(element4);
								treeitem4.setText(element4);
							}
						} else if (item1.getText().equals("WANEthernetLinkConfig")) {
							Set set5 = map5.keySet();
							for (Iterator it5 = set5.iterator(); it5.hasNext();) {
								String element5 = (String) it5.next();
								treeitem5 = new TreeItem(item1, SWT.NONE);
								treeitem5.setData(element5);
								treeitem5.setText(element5);
							}
						} else if (item1.getText().equals("LANConfigSecurity")) {
							Set set6 = map6.keySet();
							for (Iterator it6 = set6.iterator(); it6.hasNext();) {
								String element6 = (String) it6.next();
								treeitem6 = new TreeItem(item1, SWT.NONE);
								treeitem6.setData(element6);
								treeitem6.setText(element6);
							}
						} else if (item1.getText().equals("WLANConfiguration")) {
							Set set7 = map7.keySet();
							for (Iterator it7 = set7.iterator(); it7.hasNext();) {
								String element7 = (String) it7.next();
								treeitem7 = new TreeItem(item1, SWT.NONE);
								treeitem7.setData(element7);
								treeitem7.setText(element7);
							}
						} else if (item1.getText().equals("ParentalControl")) {
							Set set8 = map8.keySet();
							for (Iterator it8 = set8.iterator(); it8.hasNext();) {
								String element8 = (String) it8.next();
								treeitem8 = new TreeItem(item1, SWT.NONE);
								treeitem8.setData(element8);
								treeitem8.setText(element8);
							}
						}
					}
				} else if(treeitem.getText().equals("NetgearExtender")){
					Set set=map.keySet();
					for (Iterator it = set.iterator(); it.hasNext();) {
						String element1 = (String) it.next();
						item1 = new TreeItem(treeitem, SWT.NONE);
						item1.setData(element1);
						item1.setText(element1);
				}
		}
		}  

		tree.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				    s=(String) e.item.getData();
				    TreeItem lastitem = (TreeItem) e.item;
//				    System.out.println(s);
				    if(s.equals("GenieAPI(local)")||s.equals("NetgearExtender")
				     ||s.equals("DeviceConfig")||s.equals("DeviceInfo")
				     ||s.equals("WANIPConnection")||s.equals("WAN3GInterfaceConfig")
				     ||s.equals("WANEthernetLinkConfig")||s.equals("LANConfigSecurity")
				     ||s.equals("WLANConfiguration")||s.equals("ParentalControl")){
				    	
				    	text.setText("");//MethodName
				    	combo.setText("");//ModleName
				    	text_5.setText("");//input params
						text_1.setText("");//Arguments
						text_2.setText("");//Result
				    	
				    }else if(s.equals("Authenticate")&&lastitem.getParentItem().getText().equals("NetgearExtender")){
				    	text.setText(s);//MethodName
				    	combo.setText("DeviceConfig");//ModleName
				    	text_5.setText("NewUsername,admin;NewPassword,password");//input params
						text_1.setText(map.get(s).toString());//Arguments
						text_2.setText("");//Result
				    }else if(s.equals("GetAPInfo")&&lastitem.getParentItem().getText().equals("NetgearExtender")){
				    	text.setText(s);//MethodName
				    	combo.setText("WLANConfiguration");//ModleName
				    	text_5.setText("NewRadio,2.4G");//input params
						text_1.setText(map.get(s).toString());//Arguments
						text_2.setText("");//Result
				    }else if(s.equals("SetExtenderMode")&&lastitem.getParentItem().getText().equals("NetgearExtender")){
				    	text.setText(s);//MethodName
				    	combo.setText("WLANConfiguration");//ModleName
				    	text_5.setText("NewExtenderMode,Internet Surfing;New2GRadioMode,Extender;New5GRadioMode, ;NewBondEthernet, ");//input params
						text_1.setText(map.get(s).toString());//Arguments
						text_2.setText("");//Result
				    }else if(s.equals("ConfigurationStarted")&&lastitem.getParentItem().getText().equals("NetgearExtender")){
				    	text.setText(s);//MethodName
				    	combo.setText("DeviceConfig");//ModleName
				    	text_5.setText("");//input params
						text_1.setText(map.get(s).toString());//Arguments
						text_2.setText("");//Result
				    }else if(s.equals("SetRouterWLANWPAPSKByPassphrase")&&lastitem.getParentItem().getText().equals("NetgearExtender")){
				    	text.setText(s);//MethodName
				    	combo.setText("WLANConfiguration");//ModleName
				    	text_5.setText("NewRadio,2.4G;NewSSID,WNDR4500;NewChannel,Auto;NewWirelessMode,Auto;NewWPAEncryptionModes,WPA2-PSK-AES;NewWPAPassphrase,siteview;NewVerify,0");//input params
						text_1.setText(map.get(s).toString());//Arguments
						text_2.setText("");//Result
				    }else if(s.equals("SetWLANWPAPSKByPassphrase")&&lastitem.getParentItem().getText().equals("NetgearExtender")){
				    	text.setText(s);//MethodName
				    	combo.setText("WLANConfiguration");//ModleName
				    	text_5.setText("NewRadio,2.4G;NewSSID,WNDR4500_EXT;NewChannel,Auto;NewWirelessMode,Auto;NewWPAEncryptionModes,WPA2-PSK-AES;NewWPAPassphrase,siteview");//input params
						text_1.setText(map.get(s).toString());//Arguments
						text_2.setText("");//Result
				    }else if(s.equals("ConfigurationFinished")&&lastitem.getParentItem().getText().equals("NetgearExtender")){
				    	text.setText(s);//MethodName
				    	combo.setText("DeviceConfig");//ModleName
				    	text_5.setText("NewConfigStatus,1");//input params
						text_1.setText(map.get(s).toString());//Arguments
						text_2.setText("");//Result
				    }else if(s.equals("SetEnable")&&lastitem.getParentItem().getText().equals("NetgearExtender")){
				    	text.setText(s);//MethodName
				    	combo.setText("DeviceConfig");//ModleName
				    	text_5.setText("NewEnable,0");//input params
						text_1.setText(map.get(s).toString());//Arguments
						text_2.setText("");//Result
				    }else if(s.equals("GetRouterWLANWPAInfo")&&lastitem.getParentItem().getText().equals("NetgearExtender")){
				    	text.setText(s);//MethodName
				    	combo.setText("WLANConfiguration");//ModleName
				    	text_5.setText("NewRadio,2.4G");//input params
						text_1.setText(map.get(s).toString());//Arguments
						text_2.setText("");//Result
				    }else{
				    	text.setText(s);//MethodName
				    	combo.setText(lastitem.getParentItem().getText());//ModleName
				    	text_5.setText("");//input params
					    text_1.setText("urn:NETGEAR-ROUTER:service:"+combo.getText()+":1#"+text.getText());//Arguments
						text_2.setText("");//Result
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
		
		
		Label urllabel = new Label(grpCall, SWT.NONE);//SOAPUrl
		urllabel.setBounds(10, 32, 79, 12);
		urllabel.setText("Host");
		urllabel.setBackground(color);
		text_3 = new Text(grpCall, SWT.BORDER);
		text_3.setText("http://");
		text_3.setBounds(95, 26, 291, 18);
		text_3.setBackground(color);
		
		
		
		Label lblMethodname = new Label(grpCall, SWT.NONE);//MethodName
		lblMethodname.setBounds(10, 68, 79, 12);
		lblMethodname.setText("MethodName");
		lblMethodname.setBackground(color);
		text = new Text(grpCall, SWT.BORDER);
		text.setBounds(95, 62, 291, 18);
		text.setBackground(color);
		
		
		
		Label lblModelname = new Label(grpCall, SWT.NONE);//ModleName
		lblModelname.setBounds(10, 104, 79, 12);
		lblModelname.setText("ModleName");
		lblModelname.setBackground(color);
		combo = new Combo(grpCall, SWT.NONE);
		combo.setBounds(95, 98, 150, 18);
		combo.add("other");
		combo.add("DeviceConfig");
		combo.add("DeviceInfo");
		combo.add("LANConfigSecurity");
		combo.add("ParentalControl");
		combo.add("Time");
		combo.add("WANEthernetLinkConfig");
		combo.add("WANIPConnection");
		combo.add("WLANConfiguration");
		combo.add("WAN3GInterfaceConfig");
		text_6 = new Text(grpCall, SWT.BORDER);
		text_6.setBounds(250, 98, 136, 19);
		text_6.setBackground(color);
		
		
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
					text_1.setText("urn:NETGEAR-ROUTER:service:"+combo.getText()+":1#"+text.getText());
				}else if(combo.getText().equals("other")){
					text_1.setText("");
					text_1.setText("urn:NETGEAR-ROUTER:service:"+text_6.getText()+":1#"+text.getText());
				}
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
		
		Label inputlabel = new Label(grpCall, SWT.NONE);//input params
		inputlabel.setBounds(10, 140, 79, 12);
		inputlabel.setText("input params");
		inputlabel.setBackground(color);
		text_5 = new Text(grpCall, SWT.BORDER | SWT.WRAP|SWT.V_SCROLL);
		text_5.setBounds(95, 134, 291, 58);
		text_5.setBackground(color);
		Label tishilabel1 = new Label(grpCall, SWT.NONE);
		tishilabel1.setBounds(95, 200, 250, 12);
		tishilabel1.setText("(例:参数名1,参数值1;参数名2,参数值2)");
		tishilabel1.setBackground(color);
		Label tishilabel2 = new Label(grpCall, SWT.NONE);
		tishilabel2.setBounds(95, 218, 250, 12);
		tishilabel2.setText("(若参数值为空请用空格代替)");
		tishilabel2.setBackground(color);
		
		
		Label lblArguments = new Label(grpCall, SWT.NONE);
		lblArguments.setBounds(10, 300, 79, 12);
		lblArguments.setText("Arguments");
		lblArguments.setBackground(color);
		text_1 = new Text(grpCall, SWT.BORDER | SWT.WRAP);//Arguments
		text_1.setBounds(95, 245, 306, 223);
		text_1.setBackground(color);
		
		
		
		Label lblResult = new Label(grpCall, SWT.NONE);//Result
		lblResult.setText("Result");
		lblResult.setBounds(421, 157, 54, 12);
		lblResult.setBackground(color);
		text_2 = new Text(grpCall, SWT.BORDER | SWT.WRAP|SWT.V_SCROLL);
		text_2.setBounds(487, 42, 350, 349);
		text_2.setEditable(false);
		text_2.setBackground(color);
		
		
		
		Button button = new Button(grpCall, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {//调用按钮的事件
			public void widgetSelected(SelectionEvent e) {
//				StringBuffer xml=new StringBuffer();
//				System.out.println("Arguments:"+text_1.getText());
//				System.out.println("APIName:"+text.getText());
//				System.out.println("SoapUrl:"+text_3.getText());
//				String params=text_5.getText();
//				System.out.println("input params:"+params);
//				if(!(params.equals(""))){
//					String [] keyvalue = params.split(";");
//					xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
//					xml.append("<SOAP-ENV:Envelope \r\n");
//					xml.append("xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\"\r\n");
//					xml.append("xmlns:xsi=\"http://www.w3.org/1999/XMLSchema-instance\" \r\n");
//					xml.append("xmlns:xsd=\"http://www.w3.org/1999/XMLSchema\">\r\n");
//					xml.append("<SOAP-ENV:Body>\r\n");
//					xml.append("<"+text.getText()+">\r\n");
//					for (int i = 0; i < keyvalue.length; i++) {
//						String [] zoo = keyvalue[i].split(",");
//					    key=zoo[0];
//						value=zoo[1];
//						if(value.equals(" ")){
//							value="";
//						}
//						System.out.println("key:"+key);
//						System.out.println("value:"+value);
//						xml.append("<"+key+" xsi:type=\"xsd:string\" xmlns:xsi=\"http://www.w3.org/1999/XMLSchema-instance\">"+value+"</"+key+">\r\n");
//					}
//					xml.append("</"+text.getText()+">\r\n");
//					xml.append("</SOAP-ENV:Body>\r\n");
//					xml.append("</SOAP-ENV:Envelope>\r\n");
//					String body=xml.toString();
//					System.out.println("body:"+body);
//				}else{
//					xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
//					xml.append("<SOAP-ENV:Envelope \r\n");
//					xml.append("xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\"\r\n");
//					xml.append("xmlns:xsi=\"http://www.w3.org/1999/XMLSchema-instance\" \r\n");
//					xml.append("xmlns:xsd=\"http://www.w3.org/1999/XMLSchema\">\r\n");
//					xml.append("<SOAP-ENV:Body>\r\n");
//					xml.append("<"+text.getText()+">\r\n");
//					xml.append("</"+text.getText()+">\r\n");
//					xml.append("</SOAP-ENV:Body>\r\n");
//					xml.append("</SOAP-ENV:Envelope>\r\n");
//					String body=xml.toString();
//					System.out.println("body:"+body);
//					
//				}
				
				
				
				
				text_2.setText(SOAPClient4XG.localflowConnection(text_3.getText(),text.getText(),text_1.getText(),text_5.getText()));//result

			}
			
		});
		button.setBounds(95, 495, 72, 22); 
		button.setText("submit");
		
		Label explain = new Label(grpCall, SWT.NONE);//Instructions for use
		explain.setBounds(10, 640, 120, 12);
		explain.setText("Instructions for use");
		explain.setBackground(color);
		text_7 = new Text(grpCall, SWT.BORDER | SWT.WRAP);//Arguments
		text_7.setEditable(false);
		text_7.setBounds(135, 585, 406, 123);
		text_7.setBackground(color);
		text_7.setText("如果您需要自己添加SOAP API,可以在MethodName中填写API,ModleName中选择API相应的类型 ,input params中填写参数名和参数值.\n\r\n"+
				       "需要特别提醒您的是，如果ModleName中没有您所需要的API类型，您务必先在右侧的方框中填写你自己所需的类型，然后再将ModleName的值设为other");
		
		
		
		
		sashForm_1.setWeights(new int[] {116, 475});
		sashForm.setWeights(new int[] {1,20});
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
