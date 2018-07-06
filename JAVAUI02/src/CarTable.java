import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class CarTable extends Dialog {

	protected Object result;
	protected Shell shell;
	private Table table;
	private TableColumn tblclmnCompany;
	private Button btnNewButton;
	private Button btnDetail;
	private Button button;
	private TableColumn tblclmnPrice;
	private TableColumn tblclmnModel;
	private TableColumn tblclmnColor;
	private TableColumn tableColumncheck;

	String driver = "org.mariadb.jdbc.Driver";
	String url    = "jdbc:mariadb://localhost:3307/pmsystem";
	String id     = "root";
	String pw     = "user123456789";

	Connection connect  = null;
	Statement  stmt = null;
	ResultSet  rs   = null;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public CarTable(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		shell.setBackgroundImage(SWTResourceManager.getImage("C:\\Users\\user42\\eclipse-workspace\\Group\\gradient.png"));

		Label lblCheaperThanTier = new Label(shell, SWT.NONE);
		lblCheaperThanTier.setLocation(9, 29);
		lblCheaperThanTier.setSize(425, 53);
		lblCheaperThanTier.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblCheaperThanTier.setForeground(SWTResourceManager.getColor(255, 255, 240));
		lblCheaperThanTier.setFont(SWTResourceManager.getFont("@System", 37, SWT.BOLD));
		lblCheaperThanTier.setAlignment(SWT.CENTER);
		lblCheaperThanTier.setText("Cheaper than tire");

		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(20, 88, 467, 235);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		

		tblclmnCompany = new TableColumn(table, SWT.NONE);
		tblclmnCompany.setWidth(85);
		tblclmnCompany.setText(" Company");

		tblclmnPrice = new TableColumn(table, SWT.CENTER);
		tblclmnPrice.setWidth(101);
		tblclmnPrice.setText("Price");

		tblclmnModel = new TableColumn(table, SWT.CENTER);
		tblclmnModel.setWidth(100);
		tblclmnModel.setText("Model");

		tblclmnColor = new TableColumn(table, SWT.CENTER);
		tblclmnColor.setWidth(100);
		tblclmnColor.setText("Color");

		tableColumncheck = new TableColumn(table, SWT.CENTER);
		tableColumncheck.setText(" ");
		tableColumncheck.setWidth(76);

		Button btnclick = new Button(shell, SWT.CENTER);
		btnclick.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {

				table.setItemCount(0);
				
				try {
					Class.forName(driver);
					connect = DriverManager.getConnection(url, id, pw);
					System.out.println("성공적으로 연결");

					stmt = connect.createStatement();
					rs = stmt.executeQuery("select * from car");
					while (rs.next()) {
						TableItem item = new TableItem(table, SWT.NONE);
						item.setText(new String[] {
								rs.getString(1),
								rs.getString(2),
								rs.getString(3),
								rs.getString(4)
								});
					}
					connect.close();
				} catch (Exception e1) {
					System.out.println("Cannot found");
				}
			}
		});
		
	
		btnclick.setText("clickHere");
		btnclick.setFont(SWTResourceManager.getFont("Segoe Script", 9, SWT.NORMAL));
		btnclick.setBackgroundImage(SWTResourceManager.getImage("C:\\Users\\user42\\eclipse-workspace\\Group\\gradient.png"));
		btnclick.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		btnclick.setBounds(49, 352, 105, 47);

		btnDetail = new Button(shell, SWT.CENTER);
		btnDetail.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnDetail.setText("Update");
		btnDetail.setFont(SWTResourceManager.getFont("Segoe Script", 9, SWT.NORMAL));
		btnDetail.setBackgroundImage(SWTResourceManager.getImage("C:\\Users\\user42\\eclipse-workspace\\Group\\gradient.png"));
		btnDetail.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		btnDetail.setBounds(203, 352, 105, 47);

		button = new Button(shell, SWT.CENTER);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button.setText("Detail");
		button.setFont(SWTResourceManager.getFont("Segoe Script", 9, SWT.NORMAL));
		button.setBackgroundImage(SWTResourceManager.getImage("C:\\Users\\user42\\eclipse-workspace\\Group\\gradient.png"));
		button.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		button.setBounds(357, 352, 105, 47);

		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(514, 455);
		shell.setText(getText());

	}
}
