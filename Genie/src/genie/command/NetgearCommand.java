package genie.command;

import genie.Activator;
import genie.editor.NetgearCall;
import genie.editor.SoapApiCall;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class NetgearCommand implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		IWorkbenchPage page = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage();  
		IEditorPart editor = page.findEditor(Activator.input1); 
		try {
			if(editor==null){
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(Activator.input1, NetgearCall.ID);
			
			}else{
				editor.setFocus();
				page.activate(editor);
			}
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isHandled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

}
