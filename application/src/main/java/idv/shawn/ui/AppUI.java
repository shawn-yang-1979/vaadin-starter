package idv.shawn.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Viewport;
import com.vaadin.server.DefaultErrorHandler;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.UI;

import idv.shawn.app.HasLogger;
import idv.shawn.ui.navigation.NavigationManager;
import idv.shawn.ui.views.AccessDeniedView;

@Theme("apptheme")
@SpringUI
@Viewport("width=device-width,initial-scale=1.0,user-scalable=no")
@Title("Vaadin Starter Project")
public class AppUI extends UI implements HasLogger {

	private final SpringViewProvider viewProvider;

	private final NavigationManager navigationManager;

	private final MainView mainView;

	@Autowired
	public AppUI(SpringViewProvider viewProvider, NavigationManager navigationManager, MainView mainView) {
		this.viewProvider = viewProvider;
		this.navigationManager = navigationManager;
		this.mainView = mainView;
	}

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		setErrorHandler(event -> {
			Throwable t = DefaultErrorHandler.findRelevantThrowable(event.getThrowable());
			getLogger().error("Error during request", t);
		});

		viewProvider.setAccessDeniedViewClass(AccessDeniedView.class);
		setContent(mainView);

		navigationManager.navigateToDefaultView();
	}

}
