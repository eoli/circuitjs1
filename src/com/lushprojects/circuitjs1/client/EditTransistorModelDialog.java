package com.lushprojects.circuitjs1.client;

public class EditTransistorModelDialog extends EditDialog {

    TransistorModel model;
    TransistorElm transistorElm;
    
    public EditTransistorModelDialog(TransistorModel dm, CircuitSimulator f, TransistorElm te) {
	super(dm, f);
	model = dm;
        transistorElm = te;
	applyButton.removeFromParent();
    }

    void apply() {
	super.apply();
//	if (model.name == null || model.name.length() == 0)
//	    model.pickName();
	if (transistorElm != null)
	    transistorElm.newModelCreated(model);
    }
    
    protected void closeDialog() {
	super.closeDialog();
	EditDialog edlg = CircuitSimulator.editDialog;
	CircuitSimulator.console("resetting dialog " + edlg);
	if (edlg != null)
	    edlg.resetDialog();	
	CircuitSimulator.diodeModelEditDialog = null;
    }
}
