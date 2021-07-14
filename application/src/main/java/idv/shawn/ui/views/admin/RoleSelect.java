package idv.shawn.ui.views.admin;

import com.vaadin.ui.ComboBox;

import idv.shawn.backend.data.Role;

public class RoleSelect extends ComboBox<String> {

	public RoleSelect() {
		setCaption("Role");
		setEmptySelectionAllowed(false);
		setItems(Role.getAllRoles());
		setTextInputAllowed(false);
	}
}
