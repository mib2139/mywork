import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.awt.Color;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;

public class Test02 {

	protected Shell shell;
	Car mycar = new Car();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Test02 window = new Test02();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(481, 489);
		shell.setText("SWT Application");
		shell.setBackgroundImage(SWTResourceManager.getImage("C:\\Users\\user42\\eclipse-workspace\\Group\\gradient.png"));
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		composite.setBounds(20, 136, 425, 151);

		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setBounds(59, 79, 92, 23);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		lblNewLabel.setFont(SWTResourceManager.getFont("Small Fonts", 11, SWT.NORMAL));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblNewLabel.setText("Model");

		Combo modelCombo = new Combo(composite, SWT.NONE);
		modelCombo.setBounds(227, 79, 122, 23);
		modelCombo.setItems(new String[] {"M850i xDrive", "840d xDrive", "1.5 PHEV", "330e", "E400", "350e"});
		modelCombo.select(0);

		Label lblPrice = new Label(composite, SWT.NONE);
		lblPrice.setBounds(59, 45, 92, 23);
		lblPrice.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		lblPrice.setAlignment(SWT.CENTER);
		lblPrice.setText("Price");
		lblPrice.setFont(SWTResourceManager.getFont("Small Fonts", 11, SWT.NORMAL));
		lblPrice.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));

		Combo pricecombo = new Combo(composite, SWT.NONE);
		pricecombo.setBounds(227, 45, 122, 23);
		pricecombo.setItems(new String[] {"3000", "4000", "5000", "6000", "7000", "8000", "9000", "10000"});
		pricecombo.select(0);

		Label colorlabel = new Label(composite, SWT.NONE);
		colorlabel.setBounds(59, 113, 92, 23);
		colorlabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		colorlabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		colorlabel.setFont(SWTResourceManager.getFont("Small Fonts", 11, SWT.NORMAL));
		colorlabel.setAlignment(SWT.CENTER);
		colorlabel.setText("Color");

		Combo colorcombo = new Combo(composite, SWT.NONE);
		colorcombo.setBounds(227, 113, 122, 23);
		colorcombo.setItems(new String[] {"Red", "Blue", "Black", "Gray", "White"});
		colorcombo.select(0);
		
		Label lblCompany = new Label(composite, SWT.NONE);
		lblCompany.setText("Company");
		lblCompany.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		lblCompany.setFont(SWTResourceManager.getFont("Small Fonts", 11, SWT.NORMAL));
		lblCompany.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblCompany.setAlignment(SWT.CENTER);
		lblCompany.setBounds(59, 11, 92, 23);
		
		Combo combo = new Combo(composite, SWT.NONE);
		combo.setItems(new String[] {"BMW", "BENZ", "HYUNDAI", "KIA"});
		combo.setBounds(227, 11, 122, 23);
		combo.select(0);

		Button btnNewButton = new Button(shell, SWT.CENTER);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(combo.getText());
				System.out.println(pricecombo.getText());
				String company = combo.getText();
				int num = Integer.parseInt(pricecombo.getText())/1000;
				if (company.equals("BMW")&&num==3) {
					modelCombo.setItems(new String[] {"M850i xDrive", "840d xDrive"});
					modelCombo.select(0);
				}
				System.out.println(modelCombo.getText());
				System.out.println(colorcombo.getText());
			}
		});
		btnNewButton.setFont(SWTResourceManager.getFont("Segoe Script", 9, SWT.NORMAL));
		btnNewButton.setBounds(65, 324, 143, 47);
		btnNewButton.setBackgroundImage(SWTResourceManager.getImage("C:\\Users\\user42\\eclipse-workspace\\Group\\gradient.png"));
		btnNewButton.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		btnNewButton.setText("Click");

		Label lblCheaperThanTier = new Label(shell, SWT.NONE);
		lblCheaperThanTier.setLocation(20, 66);
		lblCheaperThanTier.setSize(425, 64);
		lblCheaperThanTier.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblCheaperThanTier.setForeground(SWTResourceManager.getColor(255, 255, 240));
		lblCheaperThanTier.setFont(SWTResourceManager.getFont("@System", 37, SWT.BOLD));
		lblCheaperThanTier.setAlignment(SWT.CENTER);
		lblCheaperThanTier.setText("Cheaper than tire");
		
		Button btnList = new Button(shell, SWT.CENTER);
		btnList.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CarTable mycar = new CarTable(shell, SWT.None);
				mycar.open();
			}
		});
		btnList.setText("List");
		btnList.setFont(SWTResourceManager.getFont("Segoe Script", 9, SWT.NORMAL));
		btnList.setBackgroundImage(SWTResourceManager.getImage("C:\\Users\\user42\\eclipse-workspace\\Group\\gradient.png"));
		btnList.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		btnList.setBounds(273, 324, 143, 47);
		


	}
}
