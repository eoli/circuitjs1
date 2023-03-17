package com.lushprojects.circuitjs1.client;

public class EditDiodeModelDialog extends EditDialog {

    DiodeModel model;
    DiodeElm diodeElm;
    
    public EditDiodeModelDialog(DiodeModel dm, CircuitSimulator f, DiodeElm de) {
	super(dm, f);
	model = dm;
	diodeElm = de;
	applyButton.removeFromParent();
    }

    void apply() {
	super.apply();
	if (model.name == null || model.name.length() == 0)
	    model.pickName();
	if (diodeElm != null)
	    diodeElm.newModelCreated(model);
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
