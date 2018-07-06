import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Combo;

public class Test01 {

	protected Shell shell;
	private Text number;
	private Text result;
	
	Person person = new Person();
	private Button Button2;
	private Group grpGender;
	private Button rdMan;
	private Button rdWoman;
	private Button btnClick;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Test01 window = new Test01();
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
		shell.setSize(450, 300);
		shell.setText("SWT Application");

		number = new Text(shell, SWT.BORDER);
		number.setBounds(20, 8, 184, 21);

		Button Button1 = new Button(shell, SWT.NONE);
		Button1.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				//System.out.println(number.getText());
				int num = Integer.parseInt(number.getText());
				System.out.println(num+10);
				num+=10;
				result.setText(String.valueOf(num));
			}
		});
		Button1.setBounds(210, 6, 76, 25);
		Button1.setText("click");
		
		result = new Text(shell, SWT.BORDER);
		result.setBounds(292, 8, 73, 21);
		
		Button2 = new Button(shell, SWT.NONE);
		Button2.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				person.setName(number.getText());
				person.setAge(Integer.parseInt(result.getText()));
				System.out.println(person.getName());
				System.out.println(person.getAge());
			}
		});
		Button2.setBounds(210, 49, 76, 25);
		Button2.setText("\uAC1D\uCCB4\uC5F0\uACB0");
		
		grpGender = new Group(shell, SWT.NONE);
		grpGender.setText("gender");
		grpGender.setBounds(35, 99, 113, 81);
		
		rdMan = new Button(grpGender, SWT.RADIO);
		rdMan.setBounds(10, 22, 91, 16);
		rdMan.setText("man");
		
		rdWoman = new Button(grpGender, SWT.RADIO);
		rdWoman.setBounds(10, 56, 91, 16);
		rdWoman.setText("woman");
		
		btnClick = new Button(shell, SWT.BORDER);
		btnClick.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (rdMan.getSelection()) {
					System.out.println("남자");
				}if (rdWoman.getSelection()) {
					System.out.println("여자");
				}
			}
		});
		btnClick.setBounds(35, 187, 76, 25);
		btnClick.setText("Click!!");
		
		Combo colorBox = new Combo(shell, SWT.NONE);
		colorBox.setItems(new String[] {"\uBE68\uAC15", "\uD30C\uB791", "\uBCF4\uB77C", "\uC5F0\uBD84\uD64D", "\uD558\uB298"});
		colorBox.setBounds(175, 111, 88, 23);
		colorBox.select(0);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			System.out.println(colorBox.getText());
			}
		});
		btnNewButton.setBounds(175, 148, 88, 25);
		btnNewButton.setText("colorSelection");

	}
}
