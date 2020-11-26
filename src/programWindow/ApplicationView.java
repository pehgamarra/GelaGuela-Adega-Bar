package programWindow;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import help.Db;
import net.proteanit.sql.DbUtils;

public class ApplicationView {
	
	//Variavel do JFrame
	private JFrame frmGelaGuelaBar;
	
	//Conexao com banco de dados
	private Connection conexao;
	PreparedStatement statement;
	
	//Variaveis da tela de login
	private JTextField textLogin;
	private JPasswordField txtSenha;
	
	//Tables da seção de Produtos
	private JTable tableProdutosNaAdega, tableProdutosParaComprar, tableProdutosEmEstoque, tableTodosProdutos;
	
	//Variaveis da Lista de Produtos na Adega
	private JTextField textFieldIdProdutosNaAdega, textFieldNomeProdutosNaAdega, textFieldQuantidadeProdutosNaAdega, textFieldPrecoProdutosNaAdega;

	//Variaveis da Lista de Estoque
	private JTextField textFieldQntCaixaProdutosEmEstoque, textFieldPrecoProdutosEmEstoque, textFieldUnidadeNaCaixa, textFieldNomeProdutosEmEstoque, textFieldIdProdutosEmEstoque;
	private JTable tableProdutosNoCarrinhoVendaAtacado;
	private JTable tableClientesVendaAtacado_1;
	private JTextField textFieldIdDoProdutoVendaAtacado;
	private JTextField textField_QuantidadeUnidadeVendaAtacado;
	private JTextField txtIdDoClienteVendaAtacado;
	private JTextField textField_NomeDoProdutoVendaAtacado;
	private JTextField textField_PrecoVendaAtacado;
	private JTable tableProdutosVendaAtacado;
	private JTextField textFieldNomeClienteCarrinhoVendaAtacado;
	private JTable tablePrecoTotal;
	private JTextField textFieldPrecoTotalVendaAtacado;
	private JTextField textFieldNomeDaEmpresaVendaAtacado;
	private JTextField textFieldUnidadesProdutosEmEstoque;
	private JTextField textField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		 try {
	            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
	 
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(ApplicationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(ApplicationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(ApplicationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(ApplicationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationView window = new ApplicationView();
					window.frmGelaGuelaBar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationView() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGelaGuelaBar = new JFrame();
		frmGelaGuelaBar.setResizable(false);
		frmGelaGuelaBar.setTitle("Gela Guela Bar & Adega - Application");
		frmGelaGuelaBar.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\gelaimages.jpg"));
		frmGelaGuelaBar.setBackground(Color.BLACK);
		frmGelaGuelaBar.setBounds(100, 100, 798, 595);
		frmGelaGuelaBar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGelaGuelaBar.getContentPane().setLayout(new CardLayout(0, 0));
		frmGelaGuelaBar.setLocationRelativeTo(null);
		conexao = Db.getConnection();
		


		JPanel telaDeLogin = new JPanel();
		frmGelaGuelaBar.getContentPane().add(telaDeLogin, "name_6482692391000");
		telaDeLogin.setLayout(null);

		JPanel menuInicial = new JPanel();
		frmGelaGuelaBar.getContentPane().add(menuInicial, "name_6512104216800");
		menuInicial.setLayout(null);

		JPanel produtosNaAdega = new JPanel();
		produtosNaAdega.setFocusable(false);
		frmGelaGuelaBar.getContentPane().add(produtosNaAdega, "name_10148521687100");

		JPanel produtosEmEstoque = new JPanel();
		frmGelaGuelaBar.getContentPane().add(produtosEmEstoque, "name_10170212866500");
		produtosEmEstoque.setLayout(null);

		JPanel produtosParaComprar = new JPanel();
		frmGelaGuelaBar.getContentPane().add(produtosParaComprar, "name_10173299634900");
		produtosParaComprar.setLayout(null);

		JPanel todosProdutos = new JPanel();
		frmGelaGuelaBar.getContentPane().add(todosProdutos, "name_10175652732000");
		todosProdutos.setLayout(null);

		JPanel vendaVarejo = new JPanel();
		frmGelaGuelaBar.getContentPane().add(vendaVarejo, "name_10177535959400");
		vendaVarejo.setLayout(null);

		JPanel vendaAtacado = new JPanel();
		frmGelaGuelaBar.getContentPane().add(vendaAtacado, "name_10180454744300");

		JPanel vendaPersonalizada = new JPanel();
		frmGelaGuelaBar.getContentPane().add(vendaPersonalizada, "name_10251987733900");
		vendaPersonalizada.setLayout(null);

		JPanel fluxoDeCaixa = new JPanel();
		frmGelaGuelaBar.getContentPane().add(fluxoDeCaixa, "name_10261460448500");
		fluxoDeCaixa.setLayout(null);

		JPanel entrada = new JPanel();
		frmGelaGuelaBar.getContentPane().add(entrada, "name_10265053203100");
		entrada.setLayout(null);

		JPanel saida = new JPanel();
		frmGelaGuelaBar.getContentPane().add(saida, "name_10266988574700");
		saida.setLayout(null);

		JPanel custoXvenda = new JPanel();
		frmGelaGuelaBar.getContentPane().add(custoXvenda, "name_10268519796800");
		custoXvenda.setLayout(null);

		JPanel orcamentoDiario = new JPanel();
		frmGelaGuelaBar.getContentPane().add(orcamentoDiario, "name_10271596026600");
		orcamentoDiario.setLayout(null);

		JPanel orcamentoMensal = new JPanel();
		frmGelaGuelaBar.getContentPane().add(orcamentoMensal, "name_10393550066500");
		orcamentoMensal.setLayout(null);

		JPanel orcamentoAnual = new JPanel();
		frmGelaGuelaBar.getContentPane().add(orcamentoAnual, "name_10409225634100");
		orcamentoAnual.setLayout(null);
		
		
		
		//
		//
		// Menu Inicial
		//
		//
		
		
		JMenuBar menuBarMenuInicial = new JMenuBar();
		menuBarMenuInicial.setBackground(Color.LIGHT_GRAY);
		menuBarMenuInicial.setBounds(0, 0, 934, 22);
		menuInicial.add(menuBarMenuInicial);

		JMenu mnProdutosMenuInicial = new JMenu("Produtos");
		mnProdutosMenuInicial.setToolTipText("");
		mnProdutosMenuInicial.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarMenuInicial.add(mnProdutosMenuInicial);

		JMenuItem mntmProdutosNaAdegaMenuInicial = new JMenuItem("Produtos na Adega");
		mntmProdutosNaAdegaMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(false);
				produtosNaAdega.setVisible(true);
			}
		});
		mntmProdutosNaAdegaMenuInicial.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosMenuInicial.add(mntmProdutosNaAdegaMenuInicial);

		JMenuItem mntmProdutosEmEstoqueMenuInicial = new JMenuItem("Produtos em Estoque");
		mntmProdutosEmEstoqueMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(false);
				produtosEmEstoque.setVisible(true);
			}
		});
		mntmProdutosEmEstoqueMenuInicial.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosMenuInicial.add(mntmProdutosEmEstoqueMenuInicial);

		JMenuItem mntmProdutosParaComprarMenuInicial = new JMenuItem("Produtos para Comprar");
		mntmProdutosParaComprarMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(false);
				produtosParaComprar.setVisible(true);
			}
		});
		mntmProdutosParaComprarMenuInicial.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		mnProdutosMenuInicial.add(mntmProdutosParaComprarMenuInicial);

		JMenuItem mntmTodosProdutosMenuInicial = new JMenuItem("Todos Produtos");
		mntmTodosProdutosMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				menuInicial.setVisible(false);
				todosProdutos.setVisible(true);
			}
		});
		mntmTodosProdutosMenuInicial.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosMenuInicial.add(mntmTodosProdutosMenuInicial);

		JMenu mnVenderMenuInicial = new JMenu("Vender");
		mnVenderMenuInicial.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarMenuInicial.add(mnVenderMenuInicial);

		JMenuItem mntmVendaVarejoMenuInicial = new JMenuItem("Venda Varejo");
		mntmVendaVarejoMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmVendaVarejoMenuInicial.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderMenuInicial.add(mntmVendaVarejoMenuInicial);

		JMenuItem mntmVendaAtacadoMenuInicial = new JMenuItem("Venda Atacado");
		mntmVendaAtacadoMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(false);
				vendaAtacado.setVisible(true);
			}
		});
		mntmVendaAtacadoMenuInicial.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderMenuInicial.add(mntmVendaAtacadoMenuInicial);

		JMenuItem mntmVendaPersonalizadaMenuInicial = new JMenuItem("Venda Personalizada");
		mntmVendaPersonalizadaMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(false);
				vendaPersonalizada.setVisible(true);
			}
		});
		mntmVendaPersonalizadaMenuInicial
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
		mnVenderMenuInicial.add(mntmVendaPersonalizadaMenuInicial);
		
		JMenu mnClientesMenuInicial = new JMenu("Clientes");
		mnClientesMenuInicial.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		menuBarMenuInicial.add(mnClientesMenuInicial);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Clientes Atacado");
		mnClientesMenuInicial.add(mntmNewMenuItem);

		JMenu mnFinanceiroMenuInicial = new JMenu("Financeiro");
		mnFinanceiroMenuInicial.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\US-dollar-icon (1).png"));
		menuBarMenuInicial.add(mnFinanceiroMenuInicial);

		JMenu mnAjudaMenuInicial = new JMenu("Ajuda");
		mnAjudaMenuInicial.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarMenuInicial.add(mnAjudaMenuInicial);

		JMenuItem mntmDadosDaVersaoMenuInicial = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoMenuInicial.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaMenuInicial.add(mntmDadosDaVersaoMenuInicial);

		JLabel lblNewLabelImagemDeFundoMenuInicial = new JLabel("");
		lblNewLabelImagemDeFundoMenuInicial
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\jw-portada.jpg"));
		lblNewLabelImagemDeFundoMenuInicial.setBounds(-140, 5, 941, 722);
		menuInicial.add(lblNewLabelImagemDeFundoMenuInicial);
		telaDeLogin.setLayout(null);
		produtosNaAdega.setLayout(null);

		//
		//
		// Produtos Na Adega
		//
		//

		JMenuBar menuBarProdutosNaAdega = new JMenuBar();
		menuBarProdutosNaAdega.setBounds(0, 0, 934, 22);
		menuBarProdutosNaAdega.setBackground(Color.LIGHT_GRAY);
		produtosNaAdega.add(menuBarProdutosNaAdega);

		JMenu mnProdutosProdutosNaAdega = new JMenu("Produtos");
		mnProdutosProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarProdutosNaAdega.add(mnProdutosProdutosNaAdega);

		JMenuItem mntmProdutosNaAdegaProdutosNaAdega = new JMenuItem("Produtos na Adega");
		mntmProdutosNaAdegaProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmProdutosNaAdegaProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosProdutosNaAdega.add(mntmProdutosNaAdegaProdutosNaAdega);

		JMenuItem mntmProdutosEmEstoqueProdutosNaAdega = new JMenuItem("Produtos em Estoque");
		mntmProdutosEmEstoqueProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(false);
				produtosEmEstoque.setVisible(true);
			}
		});
		mntmProdutosEmEstoqueProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosProdutosNaAdega.add(mntmProdutosEmEstoqueProdutosNaAdega);

		JMenuItem mntmProdutosParaComprarProdutosNaAdega = new JMenuItem("Produtos para Comprar");
		mntmProdutosParaComprarProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(false);
				produtosParaComprar.setVisible(true);
			}
		});
		mntmProdutosParaComprarProdutosNaAdega
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		mnProdutosProdutosNaAdega.add(mntmProdutosParaComprarProdutosNaAdega);

		JMenuItem mntmTodosProdutosProdutosNaAdega = new JMenuItem("Todos Produtos");
		mntmTodosProdutosProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(false);
				todosProdutos.setVisible(true);
			}
		});
		mntmTodosProdutosProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosProdutosNaAdega.add(mntmTodosProdutosProdutosNaAdega);

		JMenu mnVenderProdutosNaAdega = new JMenu("Vender");
		mnVenderProdutosNaAdega
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarProdutosNaAdega.add(mnVenderProdutosNaAdega);

		JMenuItem mntmVendaVarejoProdutosNaAdega = new JMenuItem("Venda Varejo");
		mntmVendaVarejoProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmVendaVarejoProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderProdutosNaAdega.add(mntmVendaVarejoProdutosNaAdega);

		JMenuItem mntmVendaAtacadoProdutosNaAdega = new JMenuItem("Venda Atacado");
		mntmVendaAtacadoProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(false);
				vendaAtacado.setVisible(true);
			}
		});
		mntmVendaAtacadoProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderProdutosNaAdega.add(mntmVendaAtacadoProdutosNaAdega);

		JMenuItem mntmVendaPersonalizadaProdutosNaAdega = new JMenuItem("Venda Personalizada");
		mntmVendaPersonalizadaProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(false);
				vendaPersonalizada.setVisible(true);
			}
		});
		mntmVendaPersonalizadaProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
		mnVenderProdutosNaAdega.add(mntmVendaPersonalizadaProdutosNaAdega);
		
		JMenu mnClientesProdutosNaAdega = new JMenu("Clientes");
		mnClientesProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		menuBarProdutosNaAdega.add(mnClientesProdutosNaAdega);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Clientes Atacado");
		mnClientesProdutosNaAdega.add(mntmNewMenuItem_1);

		JMenu mnFinanceiroProdutosNaAdega = new JMenu("Financeiro");
		mnFinanceiroProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\US-dollar-icon (1).png"));
		menuBarProdutosNaAdega.add(mnFinanceiroProdutosNaAdega);

		JMenu mnAjudaProdutosNaAdega = new JMenu("Ajuda");
		mnAjudaProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarProdutosNaAdega.add(mnAjudaProdutosNaAdega);

		JMenuItem mntmDadosDaVersaoProdutosNaAdega = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaProdutosNaAdega.add(mntmDadosDaVersaoProdutosNaAdega);

		JScrollPane scrollPaneProdutosNaAdega = new JScrollPane();
		scrollPaneProdutosNaAdega.setBounds(270, 77, 504, 471);
		produtosNaAdega.add(scrollPaneProdutosNaAdega);

		tableProdutosNaAdega = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	               return false;               
	        };
	        
	    };
		tableProdutosNaAdega.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tableProdutosNaAdega.getSelectedRow();
				textFieldIdProdutosNaAdega.setText(tableProdutosNaAdega.getValueAt(linha, 0).toString());
				textFieldNomeProdutosNaAdega.setText(tableProdutosNaAdega.getValueAt(linha, 1).toString());
				textFieldQuantidadeProdutosNaAdega.setText(tableProdutosNaAdega.getValueAt(linha, 2).toString());
				textFieldPrecoProdutosNaAdega.setText(tableProdutosNaAdega.getValueAt(linha, 3).toString());
			}
		});
		scrollPaneProdutosNaAdega.setViewportView(tableProdutosNaAdega);

		JButton btnListarProdutosNaAdega = new JButton("Mostrar Produtos da Adega");
		btnListarProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshtableProdutosNaAdega();
			}
		});
		btnListarProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-And-Pretzel-icon.png"));
		btnListarProdutosNaAdega.setBounds(402, 33, 252, 33);
		produtosNaAdega.add(btnListarProdutosNaAdega);

		JLabel lblIdProdutosNaAdega = new JLabel("ID do Produto : ");
		lblIdProdutosNaAdega.setVisible(false);
		lblIdProdutosNaAdega.setForeground(Color.WHITE);
		lblIdProdutosNaAdega.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdProdutosNaAdega.setBounds(39, 85, 97, 20);
		produtosNaAdega.add(lblIdProdutosNaAdega);

		JLabel lblNomeProdutosNaAdega = new JLabel("Nome :");
		lblNomeProdutosNaAdega.setForeground(Color.WHITE);
		lblNomeProdutosNaAdega.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeProdutosNaAdega.setBounds(85, 115, 48, 20);
		produtosNaAdega.add(lblNomeProdutosNaAdega);

		JLabel lblQuantidadeProdutosNaAdega = new JLabel("Quantidade (UN) :");
		lblQuantidadeProdutosNaAdega.setForeground(Color.WHITE);
		lblQuantidadeProdutosNaAdega.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuantidadeProdutosNaAdega.setBounds(25, 145, 109, 20);
		produtosNaAdega.add(lblQuantidadeProdutosNaAdega);

		JLabel lblPrecoProdutosNaAdega = new JLabel("Pre\u00E7o :");
		lblPrecoProdutosNaAdega.setForeground(Color.WHITE);
		lblPrecoProdutosNaAdega.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecoProdutosNaAdega.setBounds(86, 175, 48, 20);
		produtosNaAdega.add(lblPrecoProdutosNaAdega);

		textFieldIdProdutosNaAdega = new JTextField();
		textFieldIdProdutosNaAdega.setVisible(false);
		textFieldIdProdutosNaAdega.setBounds(154, 85, 86, 20);
		produtosNaAdega.add(textFieldIdProdutosNaAdega);
		textFieldIdProdutosNaAdega.setColumns(10);

		textFieldNomeProdutosNaAdega = new JTextField();
		textFieldNomeProdutosNaAdega.setBounds(154, 115, 86, 20);
		produtosNaAdega.add(textFieldNomeProdutosNaAdega);
		textFieldNomeProdutosNaAdega.setColumns(10);

		textFieldQuantidadeProdutosNaAdega = new JTextField();
		textFieldQuantidadeProdutosNaAdega.setBounds(154, 145, 86, 20);
		produtosNaAdega.add(textFieldQuantidadeProdutosNaAdega);
		textFieldQuantidadeProdutosNaAdega.setColumns(10);

		textFieldPrecoProdutosNaAdega = new JTextField();
		textFieldPrecoProdutosNaAdega.setBounds(154, 175, 86, 20);
		produtosNaAdega.add(textFieldPrecoProdutosNaAdega);
		textFieldPrecoProdutosNaAdega.setColumns(10);

		JButton btnAdicionarProdutosNaAdega = new JButton("Adicionar");
		btnAdicionarProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textFieldNomeProdutosNaAdega.getText().equals("")) {
					if(!textFieldQuantidadeProdutosNaAdega.getText().equals("")) {
						if(!textFieldPrecoProdutosNaAdega.getText().equals("")) {	
							try {
								String query = "insert into lojaTatuape (Produto, Unidades, PrecoUn) values (?, ?, ?)";
								PreparedStatement pst = conexao.prepareStatement(query);
								pst.setString(1, textFieldNomeProdutosNaAdega.getText());
								pst.setString(2, textFieldQuantidadeProdutosNaAdega.getText());
								pst.setString(3, textFieldPrecoProdutosNaAdega.getText());
									pst.execute();
								JOptionPane.showMessageDialog(null, "Salvo com sucesso !");
			
								pst.close();
							} catch (Exception g) {
								JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
							}
							refreshtableProdutosNaAdega();

						}else JOptionPane.showMessageDialog(null, "Preço vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
					}else JOptionPane.showMessageDialog(null, "Quantidade vazia !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
				}else JOptionPane.showMessageDialog(null, "Nome vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
			}
		});
		btnAdicionarProdutosNaAdega
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		btnAdicionarProdutosNaAdega.setBounds(85, 225, 113, 25);
		produtosNaAdega.add(btnAdicionarProdutosNaAdega);

		JButton btnAtualizarProdutosNaAdega = new JButton("Atualizar");
		btnAtualizarProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        if (admSenha().equals("1996")){
		        	if(!textFieldNomeProdutosNaAdega.getText().equals("")) {
						if(!textFieldQuantidadeProdutosNaAdega.getText().equals("")) {
							if(!textFieldPrecoProdutosNaAdega.getText().equals("")) {	
								try {
								String query = "Update lojaTatuape set Id='" + textFieldIdProdutosNaAdega.getText() + "' ,Produto = '"
										+ textFieldNomeProdutosNaAdega.getText() + "' ,Unidades = '"
										+ textFieldQuantidadeProdutosNaAdega.getText() + "' ,PrecoUn = '"
										+ textFieldPrecoProdutosNaAdega.getText() + "' where Id='"
										+ textFieldIdProdutosNaAdega.getText() + "'  ";
								PreparedStatement pst = conexao.prepareStatement(query);
								pst.execute();
								pst.close();
								JOptionPane.showMessageDialog(null, "Atualizado com sucesso !");
								
								} catch (Exception g) {
									JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
								}
								refreshtableProdutosNaAdega();

							}else JOptionPane.showMessageDialog(null, "Preço vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
						}else JOptionPane.showMessageDialog(null, "Quantidade vazia !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
					}else JOptionPane.showMessageDialog(null, "Nome vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
		        } else {
		        		JOptionPane.showMessageDialog(null, "Senha Incorreta ! Tente Novamente !");
		        }
			}
		});
		btnAtualizarProdutosNaAdega.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Files-Check-File-icon.png"));
		btnAtualizarProdutosNaAdega.setBounds(85, 260, 113, 25);
		produtosNaAdega.add(btnAtualizarProdutosNaAdega);

		JButton btnDeletarProdutosNaAdega = new JButton("Deletar");
		btnDeletarProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Deletar o Produto?", "", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
					if(!textFieldIdProdutosNaAdega.getText().equals("")) {
						try {
						String query = "delete from lojaTatuape where Id='" + textFieldIdProdutosNaAdega.getText() + "' ";
						PreparedStatement pst = conexao.prepareStatement(query);
						pst.execute();
						JOptionPane.showMessageDialog(null, "Produto Deletado !", "", JOptionPane.ERROR_MESSAGE);
						pst.close();
						} catch (Exception g) {
							JOptionPane.showMessageDialog(null, "Selecione o Produto na tabela para deletar !"); g.printStackTrace();
						}
						refreshtableProdutosNaAdega();

					}else JOptionPane.showMessageDialog(null, "Selecione o Produto na tabela para deletar !", "ERRO!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnDeletarProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\trash-icon.png"));
		btnDeletarProdutosNaAdega.setBounds(85, 295, 113, 25);
		produtosNaAdega.add(btnDeletarProdutosNaAdega);
		
		

		JButton btnNewButtonExitProdutosNaAdega;
		btnNewButtonExitProdutosNaAdega = new JButton("");
		btnNewButtonExitProdutosNaAdega.setVerifyInputWhenFocusTarget(false);
		btnNewButtonExitProdutosNaAdega.setRequestFocusEnabled(false);
		btnNewButtonExitProdutosNaAdega.setFocusable(false);
		btnNewButtonExitProdutosNaAdega.setFocusTraversalKeysEnabled(false);
		btnNewButtonExitProdutosNaAdega.setFocusPainted(false);
		btnNewButtonExitProdutosNaAdega.setBorderPainted(false);
		btnNewButtonExitProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(true);
				produtosNaAdega.setVisible(false);
			}
		});
		btnNewButtonExitProdutosNaAdega.setContentAreaFilled(false);
		btnNewButtonExitProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\Arrows-Undo-icon.png"));
		btnNewButtonExitProdutosNaAdega.setBounds(0, 23, 16, 16);
		produtosNaAdega.add(btnNewButtonExitProdutosNaAdega);
		telaDeLogin.setLayout(null);

		JLabel lblGelaGuelaImageProdutosNaAdega = new JLabel("");
		lblGelaGuelaImageProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\1111111111111111111111111111111111.jpg"));
		lblGelaGuelaImageProdutosNaAdega.setBounds(-300, 11, 753, 662);
		produtosNaAdega.add(lblGelaGuelaImageProdutosNaAdega);
		
		JLabel lblNewLabel_Fundo1 = new JLabel("");
		lblNewLabel_Fundo1.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\vede.jpg"));
		lblNewLabel_Fundo1.setBounds(363, 329, 439, 243);
		produtosNaAdega.add(lblNewLabel_Fundo1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\FundoDaJackApple2jpg.jpg"));
		lblNewLabel_6.setBounds(412, -66, 379, 402);
		produtosNaAdega.add(lblNewLabel_6);
		telaDeLogin.setLayout(null);
		
		textFieldUnidadesProdutosEmEstoque = new JTextField();
		textFieldUnidadesProdutosEmEstoque.setBounds(674, 86, 70, 20);
		produtosEmEstoque.add(textFieldUnidadesProdutosEmEstoque);
		textFieldUnidadesProdutosEmEstoque.setColumns(10);
		
		JLabel lblNewLabel_UnidadesProdutoEmEstoque = new JLabel("Unidades :");
		lblNewLabel_UnidadesProdutoEmEstoque.setForeground(Color.WHITE);
		lblNewLabel_UnidadesProdutoEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_UnidadesProdutoEmEstoque.setBounds(595, 85, 69, 20);
		produtosEmEstoque.add(lblNewLabel_UnidadesProdutoEmEstoque);


		//
		//
		// ProdutosEmEstoque
		//
		//

		JMenuBar menuBarProdutosEmEstoque = new JMenuBar();
		menuBarProdutosEmEstoque.setBounds(0, 0, 934, 22);
		menuBarProdutosEmEstoque.setBackground(Color.LIGHT_GRAY);
		produtosEmEstoque.add(menuBarProdutosEmEstoque);

		JMenu mnProdutosProdutosEmEstoque = new JMenu("Produtos");
		mnProdutosProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarProdutosEmEstoque.add(mnProdutosProdutosEmEstoque);

		JMenuItem mntmProdutosNaAdegaProdutosEmEstoque = new JMenuItem("Produtos na Adega");
		mntmProdutosNaAdegaProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(true);
				produtosEmEstoque.setVisible(false);
			}
		});
		mntmProdutosNaAdegaProdutosEmEstoque
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosProdutosEmEstoque.add(mntmProdutosNaAdegaProdutosEmEstoque);

		JMenuItem mntmProdutosEmEstoqueProdutosEmEstoque = new JMenuItem("Produtos em Estoque");
		mntmProdutosEmEstoqueProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosProdutosEmEstoque.add(mntmProdutosEmEstoqueProdutosEmEstoque);

		JMenuItem mntmProdutosParaComprarProdutosEmEstoque = new JMenuItem("Produtos para Comprar");
		mntmProdutosParaComprarProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosEmEstoque.setVisible(false);
				produtosParaComprar.setVisible(true);
			}
		});
		mntmProdutosParaComprarProdutosEmEstoque
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		mnProdutosProdutosEmEstoque.add(mntmProdutosParaComprarProdutosEmEstoque);

		JMenuItem mntmTodosProdutosProdutosEmEstoque = new JMenuItem("Todos Produtos");
		mntmTodosProdutosProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosEmEstoque.setVisible(false);
				todosProdutos.setVisible(true);
			}
		});
		mntmTodosProdutosProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosProdutosEmEstoque.add(mntmTodosProdutosProdutosEmEstoque);

		JMenu mnVenderProdutosEmEstoque = new JMenu("Vender");
		mnVenderProdutosEmEstoque
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarProdutosEmEstoque.add(mnVenderProdutosEmEstoque);

		JMenuItem mntmVendaVarejoProdutosEmEstoque = new JMenuItem("Venda Varejo");
		mntmVendaVarejoProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosEmEstoque.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmVendaVarejoProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderProdutosEmEstoque.add(mntmVendaVarejoProdutosEmEstoque);

		JMenuItem mntmVendaAtacadoProdutosEmEstoque = new JMenuItem("Venda Atacado");
		mntmVendaAtacadoProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosEmEstoque.setVisible(false);
				vendaAtacado.setVisible(true);
			}
		});
		mntmVendaAtacadoProdutosEmEstoque
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderProdutosEmEstoque.add(mntmVendaAtacadoProdutosEmEstoque);

		JMenuItem mntmVendaPersonalizadaProdutosEmEstoque = new JMenuItem("Venda Personalizada");
		mntmVendaPersonalizadaProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosEmEstoque.setVisible(false);
				vendaPersonalizada.setVisible(true);
			}
		});
		mntmVendaPersonalizadaProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
		mnVenderProdutosEmEstoque.add(mntmVendaPersonalizadaProdutosEmEstoque);
		
		JMenu mnClientesProdutosEmEstoque = new JMenu("Clientes");
		mnClientesProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		menuBarProdutosEmEstoque.add(mnClientesProdutosEmEstoque);
		
		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("Clientes Atacado");
		mnClientesProdutosEmEstoque.add(mntmNewMenuItem_1_1);

		JMenu mnFinanceiroProdutosEmEstoque = new JMenu("Financeiro");
		mnFinanceiroProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\US-dollar-icon (1).png"));
		menuBarProdutosEmEstoque.add(mnFinanceiroProdutosEmEstoque);

		JMenu mnAjudaProdutosEmEstoque = new JMenu("Ajuda");
		mnAjudaProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarProdutosEmEstoque.add(mnAjudaProdutosEmEstoque);

		JMenuItem mntmDadosDaVersaoProdutosEmEstoque = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaProdutosEmEstoque.add(mntmDadosDaVersaoProdutosEmEstoque);

		JScrollPane scrollPaneProdutosEmEstoque = new JScrollPane();
		scrollPaneProdutosEmEstoque.setBounds(150, 183, 624, 365);
		produtosEmEstoque.add(scrollPaneProdutosEmEstoque);

		tableProdutosEmEstoque = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	               return false;               
	        };
	        
	    };
		tableProdutosEmEstoque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tableProdutosEmEstoque.getSelectedRow();
				textFieldIdProdutosEmEstoque.setText(tableProdutosEmEstoque.getValueAt(linha, 0).toString());
				textFieldNomeProdutosEmEstoque.setText(tableProdutosEmEstoque.getValueAt(linha, 1).toString());
				textFieldUnidadesProdutosEmEstoque.setText(tableProdutosEmEstoque.getValueAt(linha, 2).toString());
				textFieldQntCaixaProdutosEmEstoque.setText(tableProdutosEmEstoque.getValueAt(linha, 3).toString());
				textFieldUnidadeNaCaixa.setText(tableProdutosEmEstoque.getValueAt(linha, 4).toString());
				textFieldPrecoProdutosEmEstoque.setText(tableProdutosEmEstoque.getValueAt(linha, 6).toString());
				
			}
		});
		scrollPaneProdutosEmEstoque.setViewportView(tableProdutosEmEstoque);

		JButton btnListarProdutosEmEstoque = new JButton("Mostrar Produtos no Estoque");
		btnListarProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshtableProdutosEmEstoque();
			}
		});
		btnListarProdutosEmEstoque.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\62894-package-icon.png"));
		btnListarProdutosEmEstoque.setBounds(325, 33, 252, 25);
		produtosEmEstoque.add(btnListarProdutosEmEstoque);

		JLabel lblIdProdutosEmEstoque = new JLabel("ID do Produto : ");
		lblIdProdutosEmEstoque.setVisible(false);
		lblIdProdutosEmEstoque.setForeground(Color.WHITE);
		lblIdProdutosEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdProdutosEmEstoque.setBounds(80, 49, 97, 20);
		produtosEmEstoque.add(lblIdProdutosEmEstoque);

		JLabel lblNomeProdutosEmEstoque = new JLabel("Nome do Produto :");
		lblNomeProdutosEmEstoque.setForeground(Color.WHITE);
		lblNomeProdutosEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeProdutosEmEstoque.setBounds(229, 85, 129, 20);
		produtosEmEstoque.add(lblNomeProdutosEmEstoque);

		JLabel lblPrecoProdutosEmEstoque = new JLabel("Pre\u00E7o (UN) :");
		lblPrecoProdutosEmEstoque.setForeground(Color.WHITE);
		lblPrecoProdutosEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecoProdutosEmEstoque.setBounds(595, 115, 69, 20);
		produtosEmEstoque.add(lblPrecoProdutosEmEstoque);

		textFieldIdProdutosEmEstoque = new JTextField();
		textFieldIdProdutosEmEstoque.setVisible(false);
		textFieldIdProdutosEmEstoque.setBounds(187, 50, 40, 20);
		produtosEmEstoque.add(textFieldIdProdutosEmEstoque);
		textFieldIdProdutosEmEstoque.setColumns(10);

		textFieldNomeProdutosEmEstoque = new JTextField();
		textFieldNomeProdutosEmEstoque.setBounds(353, 86, 232, 20);
		produtosEmEstoque.add(textFieldNomeProdutosEmEstoque);
		textFieldNomeProdutosEmEstoque.setColumns(10);

		textFieldUnidadeNaCaixa = new JTextField();
		textFieldUnidadeNaCaixa.setBounds(545, 115, 40, 20);
		produtosEmEstoque.add(textFieldUnidadeNaCaixa);
		textFieldUnidadeNaCaixa.setColumns(10);

		textFieldPrecoProdutosEmEstoque = new JTextField();
		textFieldPrecoProdutosEmEstoque.setBounds(674, 115, 70, 20);
		produtosEmEstoque.add(textFieldPrecoProdutosEmEstoque);
		textFieldPrecoProdutosEmEstoque.setColumns(10);
		
		textFieldQntCaixaProdutosEmEstoque = new JTextField();
		textFieldQntCaixaProdutosEmEstoque.setBounds(363, 115, 48, 20);
		produtosEmEstoque.add(textFieldQntCaixaProdutosEmEstoque);
		textFieldQntCaixaProdutosEmEstoque.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Quantidade de Caixas :");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(229, 115, 142, 20);
		produtosEmEstoque.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("Unidades por Caixa :");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(425, 115, 113, 20);
		produtosEmEstoque.add(lblNewLabel_7);
		telaDeLogin.setLayout(null);

		JButton btnAdicionarProdutosEmEstoque = new JButton("Adicionar");
		btnAdicionarProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textFieldNomeProdutosEmEstoque.getText().equals("")) {
					if(!textFieldUnidadesProdutosEmEstoque.getText().equals("")) {
						if(!textFieldQntCaixaProdutosEmEstoque.getText().equals("")) {
							if(!textFieldUnidadeNaCaixa.getText().equals("")) {
								if(!textFieldPrecoProdutosEmEstoque.getText().equals("")) {
									try {
										String query = "insert into adegagelaguela.estoque (Nome, Caixa, UnidadesSoltas, UnidadeEmCadaCaixa, PrecoDeCusto) values (?, ?, ?, ?, ?)";
										PreparedStatement pst = conexao.prepareStatement(query);
										pst.setString(1, textFieldNomeProdutosEmEstoque.getText());;
										pst.setString(2, textFieldQntCaixaProdutosEmEstoque.getText());
										pst.setString(3, textFieldUnidadesProdutosEmEstoque.getText());
										pst.setString(4, textFieldUnidadeNaCaixa.getText());
										pst.setString(5, textFieldPrecoProdutosEmEstoque.getText());
										pst.execute();
					
										JOptionPane.showMessageDialog(null, "Salvo com sucesso !");
					
										pst.close();
									} catch (SQLException g) {
										JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
									}
									refreshtableProdutosEmEstoque();
								}else JOptionPane.showMessageDialog(null, "Preço vazio!!", "ERRO!", JOptionPane.WARNING_MESSAGE);
							}else JOptionPane.showMessageDialog(null, "Unidade por caixa vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
						}else JOptionPane.showMessageDialog(null, "Quantidades de caixas vazio  !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
					}else JOptionPane.showMessageDialog(null, "Unidades soltas vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
				}else JOptionPane.showMessageDialog(null, "Nome do produto vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
			}
		});
		btnAdicionarProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		btnAdicionarProdutosEmEstoque.setBounds(409, 150, 113, 25);
		produtosEmEstoque.add(btnAdicionarProdutosEmEstoque);

		JButton btnAtualizarProdutosEmEstoque = new JButton("Atualizar");
		btnAtualizarProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textFieldNomeProdutosEmEstoque.getText().equals("")) {
					if(!textFieldUnidadesProdutosEmEstoque.getText().equals("")) {
						if(!textFieldQntCaixaProdutosEmEstoque.getText().equals("")) {
							if(!textFieldUnidadeNaCaixa.getText().equals("")) {
								if(!textFieldPrecoProdutosEmEstoque.getText().equals("")) {
									try {
							        	if(!textFieldNomeProdutosEmEstoque.getText().equals("")) {
												String query = "Update adegagelaguela.estoque set idEstoque='" + textFieldIdProdutosEmEstoque.getText() + "' ,Nome = '" + textFieldNomeProdutosEmEstoque.getText() + "' ,Caixa = '" + textFieldQntCaixaProdutosEmEstoque.getText() + "' ,UnidadesSoltas = '" + textFieldUnidadesProdutosEmEstoque.getText() +"' ,UnidadeEmCadaCaixa = '" + textFieldUnidadeNaCaixa.getText() + "' ,PrecoDeCusto = '"+ textFieldPrecoProdutosEmEstoque.getText() + "' where idEstoque='"+ textFieldIdProdutosEmEstoque.getText() + "'  ";
												PreparedStatement pst = conexao.prepareStatement(query);  
											    pst.execute();
											    pst.close();
											    JOptionPane.showMessageDialog(null, "Atualizado com sucesso !");
											}else JOptionPane.showMessageDialog(null, "Nenhum Produto selecionado !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
												
										} catch (Exception g) {
											JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
										}
							        
										refreshtableProdutosEmEstoque();
								}else JOptionPane.showMessageDialog(null, "Preço vazio!!", "ERRO!", JOptionPane.WARNING_MESSAGE);
							}else JOptionPane.showMessageDialog(null, "Unidade por caixa vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
						}else JOptionPane.showMessageDialog(null, "Quantidades de caixas vazio  !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
					}else JOptionPane.showMessageDialog(null, "Unidades soltas vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
				}else JOptionPane.showMessageDialog(null, "Nome do produto vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
			}
		});
		btnAtualizarProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Files-Check-File-icon.png"));
		btnAtualizarProdutosEmEstoque.setBounds(536, 150, 113, 25);
		produtosEmEstoque.add(btnAtualizarProdutosEmEstoque);

		JButton btnDeletarProdutosEmEstoque = new JButton("Deletar");
		btnDeletarProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Deletar o Produto?", "", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
					if(!textFieldIdProdutosEmEstoque.getText().equals("")) {	
						try {
							String query = "delete from adegagelaguela.estoque where idEstoque='" + tableProdutosEmEstoque.getValueAt(tableProdutosEmEstoque.getSelectedRow(), 0).toString() + "' ";
							PreparedStatement pst = conexao.prepareStatement(query);
							pst.execute();
							JOptionPane.showMessageDialog(null, "Produto Deletado !", "", JOptionPane.ERROR_MESSAGE);
							pst.close();
						} catch (Exception g) {
							JOptionPane.showMessageDialog(null, "Selecione um produto da tabela para excluir!!", "ERRO!", JOptionPane.WARNING_MESSAGE); g.printStackTrace();
						}
						refreshtableProdutosEmEstoque();
					}else JOptionPane.showMessageDialog(null, "Selecione um produto da tabela para excluir!!", "ERRO!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnDeletarProdutosEmEstoque
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\trash-icon.png"));
		btnDeletarProdutosEmEstoque.setBounds(662, 150, 113, 25);
		produtosEmEstoque.add(btnDeletarProdutosEmEstoque);
		
		JButton btnNewButtonExitProdutosNoEstoque = new JButton("");
		btnNewButtonExitProdutosNoEstoque.setVerifyInputWhenFocusTarget(false);
		btnNewButtonExitProdutosNoEstoque.setRequestFocusEnabled(false);
		btnNewButtonExitProdutosNoEstoque.setFocusable(false);
		btnNewButtonExitProdutosNoEstoque.setFocusTraversalKeysEnabled(false);
		btnNewButtonExitProdutosNoEstoque.setFocusPainted(false);
		btnNewButtonExitProdutosNoEstoque.setBorderPainted(false);
		btnNewButtonExitProdutosNoEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(true);
				produtosEmEstoque.setVisible(false);
			}
		});
		btnNewButtonExitProdutosNoEstoque.setContentAreaFilled(false);
		btnNewButtonExitProdutosNoEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\Actions-go-previous-icon.png"));
		btnNewButtonExitProdutosNoEstoque.setBounds(0, 23, 16, 16);
		produtosEmEstoque.add(btnNewButtonExitProdutosNoEstoque);
		telaDeLogin.setLayout(null);
		
		JLabel lblNewLabel_ProdutosEmEstoqueFundo1 = new JLabel("");
		lblNewLabel_ProdutosEmEstoqueFundo1.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\111111111111.jpg"));
		lblNewLabel_ProdutosEmEstoqueFundo1.setBounds(-244, 49, 545, 552);
		produtosEmEstoque.add(lblNewLabel_ProdutosEmEstoqueFundo1);
		
		JLabel lblNewLabel_ProdutosEmEstoqueFundo2 = new JLabel("");
		lblNewLabel_ProdutosEmEstoqueFundo2.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\aaaaaa.png"));
		lblNewLabel_ProdutosEmEstoqueFundo2.setBounds(0, 11, 800, 559);
		produtosEmEstoque.add(lblNewLabel_ProdutosEmEstoqueFundo2);
		

		//
		//
		// ProdutosParaComprar
		//
		//

		JMenuBar menuBarProdutosParaComprar = new JMenuBar();
		menuBarProdutosParaComprar.setBounds(0, 0, 934, 22);
		menuBarProdutosParaComprar.setBackground(Color.LIGHT_GRAY);
		produtosParaComprar.add(menuBarProdutosParaComprar);

		JMenu mnProdutosProdutosParaComprar = new JMenu("Produtos");
		mnProdutosProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarProdutosParaComprar.add(mnProdutosProdutosParaComprar);

		JMenuItem mntmProdutosNaAdegaProdutosParaComprar = new JMenuItem("Produtos na Adega");
		mntmProdutosNaAdegaProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(true);
				produtosParaComprar.setVisible(false);
			}
		});
		mntmProdutosNaAdegaProdutosParaComprar
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosProdutosParaComprar.add(mntmProdutosNaAdegaProdutosParaComprar);

		JMenuItem mntmProdutosParaComprarProdutosParaComprar = new JMenuItem("Produtos Em Estoque");
		mntmProdutosParaComprarProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosParaComprar.setVisible(false);
				produtosEmEstoque.setVisible(true);
			}
		});
		mntmProdutosParaComprarProdutosParaComprar
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosProdutosParaComprar.add(mntmProdutosParaComprarProdutosParaComprar);

		JMenuItem mntmTodosProdutosProdutosParaComprar = new JMenuItem("Todos Produtos");
		mntmTodosProdutosProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosParaComprar.setVisible(false);
				todosProdutos.setVisible(true);
			}
		});

		JMenuItem mntmProdutosParaComprar = new JMenuItem("Produtos para Comprar");
		mntmProdutosParaComprar
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		mnProdutosProdutosParaComprar.add(mntmProdutosParaComprar);
		mntmTodosProdutosProdutosParaComprar
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosProdutosParaComprar.add(mntmTodosProdutosProdutosParaComprar);

		JMenu mnVenderProdutosParaComprar = new JMenu("Vender");
		mnVenderProdutosParaComprar
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarProdutosParaComprar.add(mnVenderProdutosParaComprar);

		JMenuItem mntmVendaVarejoProdutosParaComprar = new JMenuItem("Venda Varejo");
		mntmVendaVarejoProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosParaComprar.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmVendaVarejoProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderProdutosParaComprar.add(mntmVendaVarejoProdutosParaComprar);

		JMenuItem mntmVendaAtacadoProdutosParaComprar = new JMenuItem("Venda Atacado");
		mntmVendaAtacadoProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosParaComprar.setVisible(false);
				vendaAtacado.setVisible(true);
			}
		});
		mntmVendaAtacadoProdutosParaComprar
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderProdutosParaComprar.add(mntmVendaAtacadoProdutosParaComprar);

		JMenuItem mntmVendaPersonalizadaProdutosParaComprar = new JMenuItem("Venda Personalizada");
		mntmVendaPersonalizadaProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosParaComprar.setVisible(false);
				vendaPersonalizada.setVisible(true);
			}
		});
		mntmVendaPersonalizadaProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
		mnVenderProdutosParaComprar.add(mntmVendaPersonalizadaProdutosParaComprar);
		
		JMenu mnClientesProdutosParaComprar = new JMenu("Clientes");
		mnClientesProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		menuBarProdutosParaComprar.add(mnClientesProdutosParaComprar);
		
		JMenuItem mntmNewMenuItem_1_1_1 = new JMenuItem("Clientes Atacado");
		mnClientesProdutosParaComprar.add(mntmNewMenuItem_1_1_1);

		JMenu mnFinanceiroProdutosParaComprar = new JMenu("Financeiro");
		mnFinanceiroProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\US-dollar-icon (1).png"));
		menuBarProdutosParaComprar.add(mnFinanceiroProdutosParaComprar);

		JMenu mnAjudaProdutosParaComprar = new JMenu("Ajuda");
		mnAjudaProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarProdutosParaComprar.add(mnAjudaProdutosParaComprar);

		JMenuItem mntmDadosDaVersaoProdutosParaComprar = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaProdutosParaComprar.add(mntmDadosDaVersaoProdutosParaComprar);

		
		JButton btnListarProdutosParaComprar = new JButton("Mostrar Lista de Compras");
		btnListarProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshtableProdutosParaComprar();
			}
		});
		btnListarProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-down-icon.png"));
		btnListarProdutosParaComprar.setBounds(402, 33, 252, 33);
		produtosParaComprar.add(btnListarProdutosParaComprar);

		JLabel lblIdProdutosParaComprar = new JLabel("ID para Compra : ");
		lblIdProdutosParaComprar.setVisible(false);
		lblIdProdutosParaComprar.setForeground(Color.WHITE);
		lblIdProdutosParaComprar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdProdutosParaComprar.setBounds(33, 85, 97, 20);
		produtosParaComprar.add(lblIdProdutosParaComprar);

		JLabel lblNomeProdutosParaComprar = new JLabel("Nome :");
		lblNomeProdutosParaComprar.setForeground(Color.WHITE);
		lblNomeProdutosParaComprar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeProdutosParaComprar.setBounds(85, 115, 48, 20);
		produtosParaComprar.add(lblNomeProdutosParaComprar);

		JLabel lblQuantidadeProdutosParaComprar = new JLabel("Quantidade (CX) :");
		lblQuantidadeProdutosParaComprar.setForeground(Color.WHITE);
		lblQuantidadeProdutosParaComprar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuantidadeProdutosParaComprar.setBounds(27, 145, 109, 20);
		produtosParaComprar.add(lblQuantidadeProdutosParaComprar);

		JLabel lblPrecoProdutosParaComprar = new JLabel("Pre\u00E7o :");
		lblPrecoProdutosParaComprar.setForeground(Color.WHITE);
		lblPrecoProdutosParaComprar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecoProdutosParaComprar.setBounds(86, 175, 48, 20);
		produtosParaComprar.add(lblPrecoProdutosParaComprar);

		JTextField textFieldIdProdutosParaComprar = new JTextField();
		textFieldIdProdutosParaComprar.setVisible(false);
		textFieldIdProdutosParaComprar.setBounds(154, 85, 86, 20);
		produtosParaComprar.add(textFieldIdProdutosParaComprar);
		textFieldIdProdutosParaComprar.setColumns(10);

		JTextField textFieldNomeProdutosParaComprar = new JTextField();
		textFieldNomeProdutosParaComprar.setBounds(154, 115, 86, 20);
		produtosParaComprar.add(textFieldNomeProdutosParaComprar);
		textFieldNomeProdutosParaComprar.setColumns(10);

		JTextField textFieldQuantidadeProdutosParaComprar = new JTextField();
		textFieldQuantidadeProdutosParaComprar.setBounds(154, 145, 86, 20);
		produtosParaComprar.add(textFieldQuantidadeProdutosParaComprar);
		textFieldQuantidadeProdutosParaComprar.setColumns(10);

		JTextField textFieldPrecoProdutosParaComprar = new JTextField();
		textFieldPrecoProdutosParaComprar.setBounds(154, 175, 86, 20);
		produtosParaComprar.add(textFieldPrecoProdutosParaComprar);
		textFieldPrecoProdutosParaComprar.setColumns(10);
		
		JScrollPane scrollPaneProdutosParaComprar = new JScrollPane();
		scrollPaneProdutosParaComprar.setBounds(270, 77, 504, 471);
		produtosParaComprar.add(scrollPaneProdutosParaComprar);

		tableProdutosParaComprar =  new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	               return false;               
	        };
	        
	    };
		tableProdutosParaComprar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tableProdutosParaComprar.getSelectedRow();
				textFieldIdProdutosParaComprar.setText(tableProdutosParaComprar.getValueAt(linha, 0).toString());
				textFieldNomeProdutosParaComprar.setText(tableProdutosParaComprar.getValueAt(linha, 1).toString());
				textFieldQuantidadeProdutosParaComprar.setText(tableProdutosParaComprar.getValueAt(linha, 2).toString());
				textFieldPrecoProdutosParaComprar.setText(tableProdutosParaComprar.getValueAt(linha, 3).toString());
			}
		});
		scrollPaneProdutosParaComprar.setViewportView(tableProdutosParaComprar);


		JButton btnAdicionarProdutosParaComprar = new JButton("Adicionar");
		btnAdicionarProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (admSenha().equals("1996")){
				
					try {
						if(!textFieldNomeProdutosParaComprar.getText().equals("")) {
							if(!textFieldQuantidadeProdutosParaComprar.getText().equals("")) {
								if(!textFieldPrecoProdutosParaComprar.getText().equals("")) {
									String query = "insert into produtosparacomprar (idParaCompra, Nome, QuantidadeUn, PrecoDeCompra) values (?, ?, ?, ?)";
									PreparedStatement pst = conexao.prepareStatement(query);
									pst.setString(1, textFieldIdProdutosParaComprar.getText());
									pst.setString(2, textFieldNomeProdutosParaComprar.getText());
									pst.setString(3, textFieldQuantidadeProdutosParaComprar.getText());
									pst.setString(4, textFieldPrecoProdutosParaComprar.getText());
									pst.execute();
									JOptionPane.showMessageDialog(null, "Salvo com sucesso !");
									pst.close();
								}else JOptionPane.showMessageDialog(null, "Preço vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
							}else JOptionPane.showMessageDialog(null, "Quantidade vazia !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
						}else JOptionPane.showMessageDialog(null, "Nome vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
					
					} catch (Exception g) {
						JOptionPane.showMessageDialog(null, "ID ja existe ou algum campo esta vazio!"); g.printStackTrace();
					}
				
				refreshtableProdutosParaComprar();
				}else JOptionPane.showMessageDialog(null, "Senha Incorreta ! Tente Novamente !");
			}
		});
		btnAdicionarProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		btnAdicionarProdutosParaComprar.setBounds(85, 225, 113, 25);
		produtosParaComprar.add(btnAdicionarProdutosParaComprar);

		JButton btnAtualizarProdutosParaComprar = new JButton("Atualizar");
		btnAtualizarProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        if (admSenha().equals("1996")){
					try {
						if(!textFieldNomeProdutosParaComprar.getText().equals("")) {
							if(!textFieldQuantidadeProdutosParaComprar.getText().equals("")) {
								if(!textFieldPrecoProdutosParaComprar.getText().equals("")) {
									String query = "Update produtosparacomprar set idParaCompra='" + textFieldIdProdutosParaComprar.getText()
											+ "' ,Nome = '" + textFieldNomeProdutosParaComprar.getText() + "' ,QuantidadeUn = '"
											+ textFieldQuantidadeProdutosParaComprar.getText() + "' ,PrecoDaCompra = '"
											+ textFieldPrecoProdutosParaComprar.getText() + "' where idParaCompra='"
											+ textFieldIdProdutosParaComprar.getText() + "'  ";
									PreparedStatement pst = conexao.prepareStatement(query);
									pst.execute();
									pst.close();
									JOptionPane.showMessageDialog(null, "Atualizado com sucesso !");
							
								}else JOptionPane.showMessageDialog(null, "Preço vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
							}else JOptionPane.showMessageDialog(null, "Quantidade vazia !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
						}else JOptionPane.showMessageDialog(null, "Nome vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);

							
					} catch (Exception g) {
						JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
					}
					refreshtableProdutosParaComprar();
		        } else {
	        		JOptionPane.showMessageDialog(null, "Senha Incorreta ! Tente Novamente !");
				}
		  }
		});
		btnAtualizarProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Files-Check-File-icon.png"));
		btnAtualizarProdutosParaComprar.setBounds(85, 260, 113, 25);
		produtosParaComprar.add(btnAtualizarProdutosParaComprar);

		JButton btnDeletarProdutosParaComprar = new JButton("Deletar");
		btnDeletarProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (admSenha().equals("1996")){
					 if(!textFieldIdProdutosParaComprar.getText().equals("")) {
						try {
							if (JOptionPane.showConfirmDialog(null, "Deletar o Produto?", "", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
								String query = "delete from produtosparacomprar where IdParaCompra='"
										+ textFieldIdProdutosParaComprar.getText() + "' ";
								PreparedStatement pst = conexao.prepareStatement(query);
								pst.execute();
								JOptionPane.showMessageDialog(null, "Produto Deletado !", "", JOptionPane.ERROR_MESSAGE);
								pst.close();
							}
						} catch (Exception g) {
							JOptionPane.showMessageDialog(null, "Selecione um produto da lista para deletar !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
						}
						refreshtableProdutosParaComprar();
					}else JOptionPane.showMessageDialog(null, "Selecione um produto da lista para deletar !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
				} else {
		        		JOptionPane.showMessageDialog(null, "Senha Incorreta ! Tente Novamente !");
					}
				}
		});
		btnDeletarProdutosParaComprar
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\trash-icon.png"));
		btnDeletarProdutosParaComprar.setBounds(85, 295, 113, 25);
		produtosParaComprar.add(btnDeletarProdutosParaComprar);
		
		JButton btnNewButtonExitProdutosParaComprar;
		btnNewButtonExitProdutosParaComprar = new JButton("");
		btnNewButtonExitProdutosParaComprar.setVerifyInputWhenFocusTarget(false);
		btnNewButtonExitProdutosParaComprar.setRequestFocusEnabled(false);
		btnNewButtonExitProdutosParaComprar.setFocusable(false);
		btnNewButtonExitProdutosParaComprar.setFocusTraversalKeysEnabled(false);
		btnNewButtonExitProdutosParaComprar.setFocusPainted(false);
		btnNewButtonExitProdutosParaComprar.setBorderPainted(false);
		btnNewButtonExitProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(true);
				produtosParaComprar.setVisible(false);
			}
		});
		btnNewButtonExitProdutosParaComprar.setContentAreaFilled(false);
		btnNewButtonExitProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\Arrows-Undo-icon.png"));
		btnNewButtonExitProdutosParaComprar.setBounds(0, 23, 16, 16);
		produtosParaComprar.add(btnNewButtonExitProdutosParaComprar);
		telaDeLogin.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(-70, 11, 865, 555);
		produtosParaComprar.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\19_Gin-Bombay-FundoListaDeCompras.jpg"));

		

		//
		// TodosOsProdutos
		//
		//

		JMenuBar menuBarTodosOsProdutos = new JMenuBar();
		menuBarTodosOsProdutos.setBounds(0, 0, 934, 22);
		menuBarTodosOsProdutos.setBackground(Color.LIGHT_GRAY);
		todosProdutos.add(menuBarTodosOsProdutos);

		JMenu mnProdutosTodosOsProdutos = new JMenu("Produtos");
		mnProdutosTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarTodosOsProdutos.add(mnProdutosTodosOsProdutos);

		JMenuItem mntmProdutosNaAdegaTodosOsProdutos = new JMenuItem("Produtos na Adega");
		mntmProdutosNaAdegaTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(true);
				todosProdutos.setVisible(false);
			}
		});
		mntmProdutosNaAdegaTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosTodosOsProdutos.add(mntmProdutosNaAdegaTodosOsProdutos);

		JMenuItem mntmTodosOsProdutosProdutosEmEstoque = new JMenuItem("Produtos Em Estoque");
		mntmTodosOsProdutosProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todosProdutos.setVisible(false);
				produtosEmEstoque.setVisible(true);
			}
		});
		mntmTodosOsProdutosProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosTodosOsProdutos.add(mntmTodosOsProdutosProdutosEmEstoque);

		JMenuItem mntmTodosProdutosTodosOsProdutos = new JMenuItem("Todos Produtos");
		mntmTodosProdutosTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JMenuItem mntmTodosOsProdutosProdutosParaComprar = new JMenuItem("Produtos para Comprar");
		mntmTodosOsProdutosProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todosProdutos.setVisible(false);
				produtosParaComprar.setVisible(true);
			}
		});
		mntmTodosOsProdutosProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		mnProdutosTodosOsProdutos.add(mntmTodosOsProdutosProdutosParaComprar);
		mntmTodosProdutosTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosTodosOsProdutos.add(mntmTodosProdutosTodosOsProdutos);

		JMenu mnVenderTodosOsProdutos = new JMenu("Vender");
		mnVenderTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarTodosOsProdutos.add(mnVenderTodosOsProdutos);

		JMenuItem mntmVendaVarejoTodosOsProdutos = new JMenuItem("Venda Varejo");
		mntmVendaVarejoTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todosProdutos.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmVendaVarejoTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderTodosOsProdutos.add(mntmVendaVarejoTodosOsProdutos);

		JMenuItem mntmVendaAtacadoTodosOsProdutos = new JMenuItem("Venda Atacado");
		mntmVendaAtacadoTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todosProdutos.setVisible(false);
				vendaAtacado.setVisible(true);
			}
		});
		mntmVendaAtacadoTodosOsProdutos
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderTodosOsProdutos.add(mntmVendaAtacadoTodosOsProdutos);

		JMenuItem mntmVendaPersonalizadaTodosOsProdutos = new JMenuItem("Venda Personalizada");
		mntmVendaPersonalizadaTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todosProdutos.setVisible(false);
				vendaPersonalizada.setVisible(true);
			}
		});
		mntmVendaPersonalizadaTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
		mnVenderTodosOsProdutos.add(mntmVendaPersonalizadaTodosOsProdutos);
		
		JMenu mnClientesTodosOsProdutos = new JMenu("Clientes");
		mnClientesTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		menuBarTodosOsProdutos.add(mnClientesTodosOsProdutos);
		
		JMenuItem mntmNewMenuItem_1_1_1_1 = new JMenuItem("Clientes Atacado");
		mnClientesTodosOsProdutos.add(mntmNewMenuItem_1_1_1_1);

		JMenu mnFinanceiroTodosOsProdutos = new JMenu("Financeiro");
		mnFinanceiroTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\US-dollar-icon (1).png"));
		menuBarTodosOsProdutos.add(mnFinanceiroTodosOsProdutos);

		JMenu mnAjudaTodosOsProdutos = new JMenu("Ajuda");
		mnAjudaTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarTodosOsProdutos.add(mnAjudaTodosOsProdutos);

		JMenuItem mntmDadosDaVersaoTodosOsProdutos = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaTodosOsProdutos.add(mntmDadosDaVersaoTodosOsProdutos);

		JScrollPane scrollPaneTodosOsProdutos = new JScrollPane();
		scrollPaneTodosOsProdutos.setBounds(270, 77, 504, 471);
		todosProdutos.add(scrollPaneTodosOsProdutos);

		

		JButton btnListarTodosOsProdutos = new JButton("Mostrar Todos os Produtos");
		btnListarTodosOsProdutos.setBorder(UIManager.getBorder("CheckBox.border"));
		btnListarTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM adegagelaguela.todosprodutos ORDER BY Produto";
					PreparedStatement pst = conexao.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					tableTodosProdutos.setModel(DbUtils.resultSetToTableModel(rs));

					pst.close();
					rs.close();

				} catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		btnListarTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\listcheck.png"));
		btnListarTodosOsProdutos.setBounds(402, 33, 252, 33);
		todosProdutos.add(btnListarTodosOsProdutos);

		JLabel lblIdTodosOsProdutos = new JLabel("ID do Produto : ");
		lblIdTodosOsProdutos.setVisible(false);
		lblIdTodosOsProdutos.setBorder(null);
		lblIdTodosOsProdutos.setForeground(Color.WHITE);
		lblIdTodosOsProdutos.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblIdTodosOsProdutos.setBackground(Color.WHITE);
		lblIdTodosOsProdutos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdTodosOsProdutos.setBounds(49, 85, 97, 20);
		todosProdutos.add(lblIdTodosOsProdutos);

		JLabel lblNomeTodosOsProdutos = new JLabel("Nome :");
		lblNomeTodosOsProdutos.setForeground(Color.WHITE);
		lblNomeTodosOsProdutos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeTodosOsProdutos.setBounds(96, 115, 48, 20);
		todosProdutos.add(lblNomeTodosOsProdutos);

		JLabel lblQuantidadeTodosOsProdutos = new JLabel("Pre\u00E7o por Unidade :");
		lblQuantidadeTodosOsProdutos.setForeground(Color.WHITE);
		lblQuantidadeTodosOsProdutos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuantidadeTodosOsProdutos.setBounds(28, 145, 109, 20);
		todosProdutos.add(lblQuantidadeTodosOsProdutos);

		JTextField textFieldIdTodosOsProdutos = new JTextField();
		textFieldIdTodosOsProdutos.setVisible(false);
		textFieldIdTodosOsProdutos.setBounds(154, 85, 86, 20);
		todosProdutos.add(textFieldIdTodosOsProdutos);
		textFieldIdTodosOsProdutos.setColumns(10);

		JTextField textFieldNomeTodosOsProdutos = new JTextField();
		textFieldNomeTodosOsProdutos.setBounds(154, 115, 86, 20);
		todosProdutos.add(textFieldNomeTodosOsProdutos);
		textFieldNomeTodosOsProdutos.setColumns(10);

		JTextField textFieldQuantidadeTodosOsProdutos = new JTextField();
		textFieldQuantidadeTodosOsProdutos.setBounds(154, 145, 86, 20);
		todosProdutos.add(textFieldQuantidadeTodosOsProdutos);
		textFieldQuantidadeTodosOsProdutos.setColumns(10);

		
		JButton btnAdicionarTodosOsProdutos = new JButton("Adicionar");
		btnAdicionarTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into todosprodutos (Produto, PrecoUnidade) values (?, ?)";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.setString(1, textFieldNomeTodosOsProdutos.getText());
					pst.setString(2, textFieldQuantidadeTodosOsProdutos.getText());
					pst.execute();

					JOptionPane.showMessageDialog(null, "Salvo com sucesso !");

					pst.close();
				} catch (Exception g) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
				}
				refreshtableTodosOsProdutos();
			}
		});
		btnAdicionarTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		btnAdicionarTodosOsProdutos.setBounds(85, 225, 113, 25);
		todosProdutos.add(btnAdicionarTodosOsProdutos);

		JButton btnAtualizarTodosOsProdutos = new JButton("Atualizar");
		btnAtualizarTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (admSenha().equals("1996")){
					 try {
						 if(!textFieldIdTodosOsProdutos.getText().equals("")) {
							 
							String query = "Update todosprodutos set Id='" + textFieldIdTodosOsProdutos.getText()+ "' ,Produto = '" + textFieldNomeTodosOsProdutos.getText() + "' ,PrecoUnidade = '"+ textFieldQuantidadeTodosOsProdutos.getText() + "' where Id='"+ textFieldIdTodosOsProdutos.getText() + "'  ";
							PreparedStatement pst = conexao.prepareStatement(query);
							pst.execute();
							pst.close();
							JOptionPane.showMessageDialog(null, "Atualizado com sucesso !");
							
						 }else JOptionPane.showMessageDialog(null, "Nenhum Produto selecionado !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
								
					 } catch (Exception g) {
							JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
					 }	
					 refreshtableTodosOsProdutos();
			    } else JOptionPane.showMessageDialog(null, "Senha Incorreta ! Tente Novamente !");
			}
		});
		btnAtualizarTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Files-Check-File-icon.png"));
		btnAtualizarTodosOsProdutos.setBounds(85, 260, 113, 25);
		todosProdutos.add(btnAtualizarTodosOsProdutos);

		JButton btnDeletarTodosOsProdutos = new JButton("Deletar");
		btnDeletarTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Deletar o Produto?", "", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
					try {
						String query = "delete from todosprodutos where Id='"
								+ textFieldIdTodosOsProdutos.getText() + "' ";
						PreparedStatement pst = conexao.prepareStatement(query);
						pst.execute();
						JOptionPane.showMessageDialog(null, "Produto Deletado !", "", JOptionPane.ERROR_MESSAGE);
						pst.close();
					} catch (Exception g) {
						JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
					}
					refreshtableTodosOsProdutos();
				}
			}
		});
		btnDeletarTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\trash-icon.png"));
		btnDeletarTodosOsProdutos.setBounds(85, 295, 113, 25);
		todosProdutos.add(btnDeletarTodosOsProdutos);
		
		JButton btnNewButtonExitTodosOsProdutos;
		btnNewButtonExitTodosOsProdutos = new JButton("");
		btnNewButtonExitTodosOsProdutos.setVerifyInputWhenFocusTarget(false);
		btnNewButtonExitTodosOsProdutos.setRequestFocusEnabled(false);
		btnNewButtonExitTodosOsProdutos.setFocusable(false);
		btnNewButtonExitTodosOsProdutos.setFocusTraversalKeysEnabled(false);
		btnNewButtonExitTodosOsProdutos.setFocusPainted(false);
		btnNewButtonExitTodosOsProdutos.setBorderPainted(false);
		btnNewButtonExitTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(true);
				todosProdutos.setVisible(false);
			}
		});
		btnNewButtonExitTodosOsProdutos.setContentAreaFilled(false);
		btnNewButtonExitTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\Arrows-Undo-icon.png"));
		btnNewButtonExitTodosOsProdutos.setBounds(0, 23, 16, 16);
		todosProdutos.add(btnNewButtonExitTodosOsProdutos);
		telaDeLogin.setLayout(null);
		
		tableTodosProdutos =  new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	               return false;               
	        };
	        
	    };
	    tableTodosProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tableTodosProdutos.getSelectedRow();
				textFieldIdTodosOsProdutos.setText(tableTodosProdutos.getValueAt(linha, 0).toString());
				textFieldNomeTodosOsProdutos.setText(tableTodosProdutos.getValueAt(linha, 1).toString());
				textFieldQuantidadeTodosOsProdutos.setText(tableTodosProdutos.getValueAt(linha, 2).toString());
			}
		});
		tableTodosProdutos.setOpaque(false);
		scrollPaneTodosOsProdutos.setViewportView(tableTodosProdutos);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\e74e4d60430d27452f47f279859c921a.jpg"));
		lblNewLabel_1.setBounds(-129, 77, 435, 493);
		todosProdutos.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\52f47f279859c921a.jpg"));
		lblNewLabel.setBounds(0, 21, 782, 535);
		todosProdutos.add(lblNewLabel);
		telaDeLogin.setLayout(null);
		vendaAtacado.setLayout(null);
		
		textFieldNomeDaEmpresaVendaAtacado = new JTextField();
		textFieldNomeDaEmpresaVendaAtacado.setEditable(false);
		textFieldNomeDaEmpresaVendaAtacado.setBounds(359, 452, 139, 20);
		vendaAtacado.add(textFieldNomeDaEmpresaVendaAtacado);
		textFieldNomeDaEmpresaVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_EmpresaVendaAtacado = new JLabel("Empresa :");
		lblNewLabel_EmpresaVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		lblNewLabel_EmpresaVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_EmpresaVendaAtacado.setBounds(272, 452, 89, 20);
		vendaAtacado.add(lblNewLabel_EmpresaVendaAtacado);
		
		//
		//
		//VENDA ATACADO
		//
		//

		JMenuBar menuBarVendaAtacado = new JMenuBar();
		menuBarVendaAtacado.setBounds(0, 0, 934, 22);
		menuBarVendaAtacado.setBackground(Color.LIGHT_GRAY);
		vendaAtacado.add(menuBarVendaAtacado);

		JMenu mnProdutosVendaAtacado = new JMenu("Produtos");
		mnProdutosVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarVendaAtacado.add(mnProdutosVendaAtacado);

		JMenuItem mntmProdutosNaAdegaVendaAtacado = new JMenuItem("Produtos na Adega");
		mntmProdutosNaAdegaVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(true);
				vendaAtacado.setVisible(false);
			}
		});
		mntmProdutosNaAdegaVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosVendaAtacado.add(mntmProdutosNaAdegaVendaAtacado);

		JMenuItem mntmProdutosEmEstoqueVendaAtacado = new JMenuItem("Produtos Em Estoque");
		mntmProdutosEmEstoqueVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaAtacado.setVisible(false);
				produtosEmEstoque.setVisible(true);
			}
		});
		mntmProdutosEmEstoqueVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosVendaAtacado.add(mntmProdutosEmEstoqueVendaAtacado);

		JMenuItem mntmTodosOsProdutosVendaAtacado;
		mntmTodosOsProdutosVendaAtacado = new JMenuItem("Todos Produtos");
		mntmTodosOsProdutosVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaAtacado.setVisible(false);
				todosProdutos.setVisible(true);
			}
		});
		
				JMenuItem mntmProdutosParaComprarVendaAtacado = new JMenuItem("Produtos para Comprar");
				mntmProdutosParaComprarVendaAtacado.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						vendaAtacado.setVisible(false);
						produtosParaComprar.setVisible(true);
					}
				});
				mntmProdutosParaComprarVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
				mnProdutosVendaAtacado.add(mntmProdutosParaComprarVendaAtacado);
		mntmTodosOsProdutosVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosVendaAtacado.add(mntmTodosOsProdutosVendaAtacado);

		JMenu mnVenderVendaAtacado = new JMenu("Vender");
		mnVenderVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarVendaAtacado.add(mnVenderVendaAtacado);

		JMenuItem mntmVendaVarejoVendaAtacado = new JMenuItem("Venda Varejo");
		mntmVendaVarejoVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaAtacado.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmVendaVarejoVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderVendaAtacado.add(mntmVendaVarejoVendaAtacado);

		JMenuItem mntmVendaPersonalizadaVendaAtacado = new JMenuItem("Venda Personalizada");
		mntmVendaPersonalizadaVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaAtacado.setVisible(false);
				vendaPersonalizada.setVisible(true);
			}
		});
		
		JMenuItem mntmVendaAtacadoVendaAtacado = new JMenuItem("Venda Atacado");
		mntmVendaAtacadoVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderVendaAtacado.add(mntmVendaAtacadoVendaAtacado);
		mntmVendaPersonalizadaVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
		mnVenderVendaAtacado.add(mntmVendaPersonalizadaVendaAtacado);
		
		JMenu mnClientesVendaAtacado = new JMenu("Clientes");
		mnClientesVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		menuBarVendaAtacado.add(mnClientesVendaAtacado);
		
		JMenuItem mntmNewMenuItem_1_1_1_2 = new JMenuItem("Clientes Atacado");
		mnClientesVendaAtacado.add(mntmNewMenuItem_1_1_1_2);

		JMenu mnFinanceiroVendaAtacado = new JMenu("Financeiro");
		mnFinanceiroVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\US-dollar-icon (1).png"));
		menuBarVendaAtacado.add(mnFinanceiroVendaAtacado);

		JMenu mnAjudaVendaAtacado = new JMenu("Ajuda");
		mnAjudaVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarVendaAtacado.add(mnAjudaVendaAtacado);

		JMenuItem mntmDadosDaVersaoVendaAtacado = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaVendaAtacado.add(mntmDadosDaVersaoVendaAtacado);

		tableClientesVendaAtacado_1 = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	        
	    };
		tableClientesVendaAtacado_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton btnNewButton_ClientesVendaAtacado = new JButton("Clientes :");
		btnNewButton_ClientesVendaAtacado.setBounds(77, 389, 115, 23);
		btnNewButton_ClientesVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTableClientesVendaAtacado();
			}
		});
		btnNewButton_ClientesVendaAtacado.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_ClientesVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Alphabetical-Sorting-icon.png"));
		vendaAtacado.add(btnNewButton_ClientesVendaAtacado);
		
		JScrollPane scrollPane_ClientesVendaAtacado = new JScrollPane();
		scrollPane_ClientesVendaAtacado.setBounds(20, 423, 242, 122);
		vendaAtacado.add(scrollPane_ClientesVendaAtacado);
		
		tableClientesVendaAtacado_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tableClientesVendaAtacado_1.getSelectedRow();
				txtIdDoClienteVendaAtacado.setText(tableClientesVendaAtacado_1.getValueAt(linha, 0).toString());
				textFieldNomeClienteCarrinhoVendaAtacado.setText(tableClientesVendaAtacado_1.getValueAt(linha, 1).toString());
				textFieldNomeDaEmpresaVendaAtacado.setText(tableClientesVendaAtacado_1.getValueAt(linha, 2).toString());
			}
		});
		scrollPane_ClientesVendaAtacado.setViewportView(tableClientesVendaAtacado_1);

		JButton btnNewButton_ProdutosVendaAtacado = new JButton("Produtos :");
		btnNewButton_ProdutosVendaAtacado.setBounds(489, 33, 115, 23);
		btnNewButton_ProdutosVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT idEstoque 'ID', Produto 'Nome do Produto', QuantidadeAtual 'Quantidade Disponivel', PrecoDeCusto 'Preço do Produto' FROM adegagelaguela.estoque ORDER BY Produto";
					PreparedStatement pst = conexao.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					tableProdutosVendaAtacado.setModel(DbUtils.resultSetToTableModel(rs));
					
					pst.close();
					rs.close();

				} catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		btnNewButton_ProdutosVendaAtacado.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_ProdutosVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Alphabetical-Sorting-2-icon.png"));
		vendaAtacado.add(btnNewButton_ProdutosVendaAtacado);
		
		JLabel lblNewLabel_AddProdVendaAtacado = new JLabel("Venda de Produtos Atacado :");
		lblNewLabel_AddProdVendaAtacado.setBounds(20, 25, 242, 20);
		lblNewLabel_AddProdVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\money-icon.png"));
		lblNewLabel_AddProdVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 14));
		vendaAtacado.add(lblNewLabel_AddProdVendaAtacado);

		
		
		textFieldIdDoProdutoVendaAtacado = new JTextField();
		textFieldIdDoProdutoVendaAtacado.setVisible(false);
		textFieldIdDoProdutoVendaAtacado.setBounds(620, 37, 11, 14);
		textFieldIdDoProdutoVendaAtacado.setEditable(false);
		vendaAtacado.add(textFieldIdDoProdutoVendaAtacado);
		textFieldIdDoProdutoVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_QuantiadeUnidadeVendaAtacado = new JLabel("Quantidade por Unidades :");
		lblNewLabel_QuantiadeUnidadeVendaAtacado.setBounds(20, 140, 157, 20);
		vendaAtacado.add(lblNewLabel_QuantiadeUnidadeVendaAtacado);
		
		textField_QuantidadeUnidadeVendaAtacado = new JTextField();
		textField_QuantidadeUnidadeVendaAtacado.setBounds(172, 140, 122, 20);
		vendaAtacado.add(textField_QuantidadeUnidadeVendaAtacado);
		textField_QuantidadeUnidadeVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_ClienteVendaVendaAtacado = new JLabel("Cliente :");
		lblNewLabel_ClienteVendaVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		lblNewLabel_ClienteVendaVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_ClienteVendaVendaAtacado.setBounds(272, 421, 103, 20);
		vendaAtacado.add(lblNewLabel_ClienteVendaVendaAtacado);
		
		txtIdDoClienteVendaAtacado = new JTextField();
		txtIdDoClienteVendaAtacado.setVisible(false);
		txtIdDoClienteVendaAtacado.setBounds(0, 11, 31, 20);
		txtIdDoClienteVendaAtacado.setEditable(false);
		vendaAtacado.add(txtIdDoClienteVendaAtacado);
		txtIdDoClienteVendaAtacado.setColumns(10);
		
		JButton btnNewButton_AddCarrinhoVendaAtacado = new JButton("Adicionar  ao Carrinho");
		btnNewButton_AddCarrinhoVendaAtacado.setBounds(205, 189, 149, 23);
		btnNewButton_AddCarrinhoVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textFieldIdDoProdutoVendaAtacado.getText().equals("")) {
					if(!textField_QuantidadeUnidadeVendaAtacado.getText().equals("") && !textField_QuantidadeUnidadeVendaAtacado.getText().equals("0")&& 
							!textField_QuantidadeUnidadeVendaAtacado.getText().equals("00")&& !textField_QuantidadeUnidadeVendaAtacado.getText().equals("000")) {
						try {
							String query = "INSERT INTO adegagelaguela.carrinho (Estoque_idEstoque, PrecoDeVenda, QuantidadeAVender) VALUES (?, ?, ?) ";
							PreparedStatement pst = conexao.prepareStatement(query);
							pst.setString(1, textFieldIdDoProdutoVendaAtacado.getText());
							pst.setString(2, tableProdutosVendaAtacado.getValueAt(tableProdutosVendaAtacado.getSelectedRow(), 2).toString());
							pst.setString(3, textField_QuantidadeUnidadeVendaAtacado.getText());
							pst.execute();
							pst.close();
							
							JOptionPane.showMessageDialog(null, "PRODUTO ADICIONADO !", "", JOptionPane.INFORMATION_MESSAGE);
						
						} catch (Exception g) {
							JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
							
						}
						refreshtableCarrinhoVendaAtacado();
					}else JOptionPane.showMessageDialog(null, "Quantidade não pode estar vazia ou ser '0' !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
				}else JOptionPane.showMessageDialog(null, "Selecione um produto da tabela ao lado !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
			}
		});
		btnNewButton_AddCarrinhoVendaAtacado.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_AddCarrinhoVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		vendaAtacado.add(btnNewButton_AddCarrinhoVendaAtacado);
		
		JButton btnNewButton_RemoverCarrinhoVendaAtacado = new JButton("Remover do Carrinho");
		btnNewButton_RemoverCarrinhoVendaAtacado.setBounds(364, 189, 149, 23);
		btnNewButton_RemoverCarrinhoVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Deletar o Produto do carrinho?", "", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {	
						try {
							String query = "delete from carrinho where idcarrinho='" + tableProdutosNoCarrinhoVendaAtacado.getValueAt(tableProdutosNoCarrinhoVendaAtacado.getSelectedRow(), 0).toString() + "' ";
							PreparedStatement pst = conexao.prepareStatement(query);
							pst.execute();
							JOptionPane.showMessageDialog(null, "PRODUTO REMOVIDO!", "", JOptionPane.ERROR_MESSAGE);
							pst.close();
						} catch (Exception g) {
							JOptionPane.showMessageDialog(null,"Selecione um produto da tabela abaixo !!", "ERROR!", JOptionPane.WARNING_MESSAGE); g.printStackTrace();
						}
						refreshtableCarrinhoVendaAtacado();
				}
			}
		});
		btnNewButton_RemoverCarrinhoVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\trash-icon.png"));
		btnNewButton_RemoverCarrinhoVendaAtacado.setFont(new Font("Tahoma", Font.PLAIN, 9));
		vendaAtacado.add(btnNewButton_RemoverCarrinhoVendaAtacado);
		

		JButton btnNewButton_LimparProdutosVendaAtacado = new JButton("Limpar Carrinho");
		btnNewButton_LimparProdutosVendaAtacado.setBounds(523, 329, 149, 23);
		btnNewButton_LimparProdutosVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Deletar TODOS Produtos do carrinho?", "", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
					try {
						String query = "delete from carrinho where Limpador=1";
						PreparedStatement pst = conexao.prepareStatement(query);
						pst.execute();
						JOptionPane.showMessageDialog(null, "Carrinho Limpo!", "", JOptionPane.INFORMATION_MESSAGE);
						pst.close();
					} catch (Exception g) {
						JOptionPane.showMessageDialog(null, "ERROR!"); g.printStackTrace();
					}
					refreshtableCarrinhoVendaAtacado();
				}
			}
		});
		btnNewButton_LimparProdutosVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\trash-icon.png"));
		btnNewButton_LimparProdutosVendaAtacado.setFont(new Font("Tahoma", Font.PLAIN, 9));
		vendaAtacado.add(btnNewButton_LimparProdutosVendaAtacado);
		
		JLabel lblNewLabel_ProdutosNoCarrinhoVendaAtacado = new JLabel("Produtos no carrinho :");
		lblNewLabel_ProdutosNoCarrinhoVendaAtacado.setBounds(20, 189, 142, 20);
		lblNewLabel_ProdutosNoCarrinhoVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 12));
		vendaAtacado.add(lblNewLabel_ProdutosNoCarrinhoVendaAtacado);
		
		JScrollPane scrollPaneCarrinhoVendaAtacado = new JScrollPane();
		scrollPaneCarrinhoVendaAtacado.setBounds(20, 220, 493, 132);
		vendaAtacado.add(scrollPaneCarrinhoVendaAtacado);
		
		tableProdutosNoCarrinhoVendaAtacado = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	        
	    };
		scrollPaneCarrinhoVendaAtacado.setViewportView(tableProdutosNoCarrinhoVendaAtacado);
		
		JLabel lblNewLabelNomeDoProdutoVendaAtacado = new JLabel("Nome do Produto : ");
		lblNewLabelNomeDoProdutoVendaAtacado.setBounds(20, 60, 120, 20);
		vendaAtacado.add(lblNewLabelNomeDoProdutoVendaAtacado);
		
		textField_NomeDoProdutoVendaAtacado = new JTextField();
		textField_NomeDoProdutoVendaAtacado.setBounds(137, 60, 157, 20);
		textField_NomeDoProdutoVendaAtacado.setEditable(false);
		vendaAtacado.add(textField_NomeDoProdutoVendaAtacado);
		textField_NomeDoProdutoVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_PrecoVendaAtacado = new JLabel("Pre\u00E7o por Unidade :");
		lblNewLabel_PrecoVendaAtacado.setBounds(20, 100, 120, 20);
		vendaAtacado.add(lblNewLabel_PrecoVendaAtacado);
		
		textField_PrecoVendaAtacado = new JTextField();
		textField_PrecoVendaAtacado.setBounds(137, 100, 157, 20);
		textField_PrecoVendaAtacado.setEditable(false);
		vendaAtacado.add(textField_PrecoVendaAtacado);
		textField_PrecoVendaAtacado.setColumns(10);
		
		JScrollPane scrollPane_ProdutosVendaAtacado = new JScrollPane();
		scrollPane_ProdutosVendaAtacado.setBounds(327, 56, 432, 122);
		vendaAtacado.add(scrollPane_ProdutosVendaAtacado);
		
		tableProdutosVendaAtacado = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
		tableProdutosVendaAtacado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tableProdutosVendaAtacado.getSelectedRow();
				textFieldIdDoProdutoVendaAtacado.setText(tableProdutosVendaAtacado.getValueAt(linha, 0).toString());
				textField_NomeDoProdutoVendaAtacado.setText(tableProdutosVendaAtacado.getValueAt(linha, 1).toString());
				textField_PrecoVendaAtacado.setText("R$ :  " + tableProdutosVendaAtacado.getValueAt(linha, 3).toString() + "0");
				
				
			}
		});
		scrollPane_ProdutosVendaAtacado.setViewportView(tableProdutosVendaAtacado);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(172, 189, 25, 22);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshtableCarrinhoVendaAtacado();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		vendaAtacado.add(btnNewButton_1);
		
		textFieldNomeClienteCarrinhoVendaAtacado = new JTextField();
		textFieldNomeClienteCarrinhoVendaAtacado.setEditable(false);
		textFieldNomeClienteCarrinhoVendaAtacado.setBounds(359, 421, 139, 20);
		vendaAtacado.add(textFieldNomeClienteCarrinhoVendaAtacado);
		textFieldNomeClienteCarrinhoVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_PrecoTotal = new JLabel("Pre\u00E7o Total :");
		lblNewLabel_PrecoTotal.setBounds(518, 207, 163, 41);
		lblNewLabel_PrecoTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_PrecoTotal.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\US-dollar-icon.png"));
		vendaAtacado.add(lblNewLabel_PrecoTotal);
		
		JScrollPane scrollPanePrecoTotal = new JScrollPane();
		scrollPanePrecoTotal.setBounds(0, 31, 11, 14);
		scrollPanePrecoTotal.setVisible(false);
		vendaAtacado.add(scrollPanePrecoTotal);
		
		tablePrecoTotal = new JTable();
		scrollPanePrecoTotal.setViewportView(tablePrecoTotal);
		
		textFieldPrecoTotalVendaAtacado = new JTextField();
		textFieldPrecoTotalVendaAtacado.setBounds(642, 218, 115, 20);
		textFieldPrecoTotalVendaAtacado.setEditable(false);
		vendaAtacado.add(textFieldPrecoTotalVendaAtacado);
		textFieldPrecoTotalVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_FormaDePgmVendaAtacado = new JLabel("Forma de Pagamento :");
		lblNewLabel_FormaDePgmVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_FormaDePgmVendaAtacado.setBounds(554, 390, 201, 20);
		vendaAtacado.add(lblNewLabel_FormaDePgmVendaAtacado);
		
		
		JCheckBox chckbxAPagarVendaAtacado = new JCheckBox("Pagamento futuro");
		chckbxAPagarVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxAPagarVendaAtacado.setOpaque(false);
		chckbxAPagarVendaAtacado.setBounds(272, 489, 157, 23);
		vendaAtacado.add(chckbxAPagarVendaAtacado);
		
		JCheckBox chckbxCartaoVendaAtacado = new JCheckBox("Cart\u00E3o");
		chckbxCartaoVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxCartaoVendaAtacado.setOpaque(false);
		chckbxCartaoVendaAtacado.setBounds(554, 451, 72, 23);
		vendaAtacado.add(chckbxCartaoVendaAtacado);
		
		JCheckBox chckbxDinheiroVendaAtacado = new JCheckBox("Dinheiro");
		chckbxDinheiroVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxDinheiroVendaAtacado.setOpaque(false);
		chckbxDinheiroVendaAtacado.setIcon(null);
		chckbxDinheiroVendaAtacado.setBounds(554, 420, 79, 23);
		vendaAtacado.add(chckbxDinheiroVendaAtacado);
		
		JLabel lblNewLabel_3 = new JLabel("Selecione um cliente para venda :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(20, 350, 310, 41);
		vendaAtacado.add(lblNewLabel_3);
		
		JButton btnNewButtonVenderVendaAtacado = new JButton("Vender");
		btnNewButtonVenderVendaAtacado.setBounds(614, 522, 158, 23);
		btnNewButtonVenderVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButtonVenderVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!chckbxAPagarVendaAtacado.isSelected()) {
					if (JOptionPane.showConfirmDialog(null, "Deseja finalizar a venda?", "Confirmação de Venda", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
						int contador = 0;
						if(chckbxDinheiroVendaAtacado.isSelected() && chckbxCartaoVendaAtacado.isSelected()) {
							JOptionPane.showMessageDialog(null, "Selecione apenas um metodo para pagar!", "", JOptionPane.INFORMATION_MESSAGE);
							}else if(!chckbxDinheiroVendaAtacado.isSelected() && !chckbxCartaoVendaAtacado.isSelected()) {
								JOptionPane.showMessageDialog(null, "Selecione um metodo para pagar!", "", JOptionPane.INFORMATION_MESSAGE);
								}else if(chckbxDinheiroVendaAtacado.isSelected()) {
									while(tableProdutosNoCarrinhoVendaAtacado.getRowCount() != contador) {
										try {
											String query = "INSERT INTO adegagelaguela.venda (Cliente_idCliente, Carrinho_idCarrinho, FormaDePgmt) VALUES (?, ?, ?)";
											PreparedStatement pst = conexao.prepareStatement(query);
											pst.setString(1, txtIdDoClienteVendaAtacado.getText());
											pst.setString(2, tableProdutosNoCarrinhoVendaAtacado.getValueAt(contador, 0).toString());
											pst.setString(3, "Dinheiro");
											pst.execute();
											pst.close();
											contador++;
										} catch (Exception g) {
											g.printStackTrace();
										}
								}JOptionPane.showMessageDialog(null, "Venda Realizada!", "", JOptionPane.INFORMATION_MESSAGE);
									}else if(chckbxCartaoVendaAtacado.isSelected()) {
										while(tableProdutosNoCarrinhoVendaAtacado.getRowCount() != contador) {
											try {
												String query = "INSERT INTO adegagelaguela.venda (Cliente_idCliente, Carrinho_idCarrinho, FormaDePgmt) VALUES (?, ?, ?)";
												PreparedStatement pst = conexao.prepareStatement(query);
												pst.setString(1, txtIdDoClienteVendaAtacado.getText());
												pst.setString(2, tableProdutosNoCarrinhoVendaAtacado.getValueAt(contador, 0).toString());
												pst.setString(3, "Cartão");
												pst.execute();
												pst.close();
												contador++;
											} catch (Exception g) {
												g.printStackTrace();
											}	
							}JOptionPane.showMessageDialog(null, "Venda Realizada!", "", JOptionPane.INFORMATION_MESSAGE);
						
						}
					}	
				}else if (chckbxAPagarVendaAtacado.isSelected()) {
					if (JOptionPane.showConfirmDialog(null, "Deseja finalizar a venda?", "Confirmação de Venda", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
						int contador = 0;
						if(chckbxDinheiroVendaAtacado.isSelected() && chckbxCartaoVendaAtacado.isSelected()) {
							JOptionPane.showMessageDialog(null, "Selecione apenas um metodo para pagar!", "", JOptionPane.INFORMATION_MESSAGE);
							}else if(!chckbxDinheiroVendaAtacado.isSelected() && !chckbxCartaoVendaAtacado.isSelected()) {
								JOptionPane.showMessageDialog(null, "Selecione um metodo para pagar!", "", JOptionPane.INFORMATION_MESSAGE);
								}else if(chckbxDinheiroVendaAtacado.isSelected()) {
									while(tableProdutosNoCarrinhoVendaAtacado.getRowCount() != contador) {
										try {
											String query = "INSERT INTO adegagelaguela.venda (Cliente_idCliente, Carrinho_idCarrinho, FormaDePgmt, PagamentoFuturo ) VALUES (?, ?, ?, ?)";
											PreparedStatement pst = conexao.prepareStatement(query);
											pst.setString(1, txtIdDoClienteVendaAtacado.getText());
											pst.setString(2, tableProdutosNoCarrinhoVendaAtacado.getValueAt(contador, 0).toString());
											pst.setString(3, "Dinheiro");
											pst.setString(4, "SIM");
											pst.execute();
											pst.close();
											contador++;
										} catch (Exception g) {
											g.printStackTrace();
										}
								}JOptionPane.showMessageDialog(null, "Venda Realizada!", "", JOptionPane.INFORMATION_MESSAGE);
									}else if(chckbxCartaoVendaAtacado.isSelected()) {
										while(tableProdutosNoCarrinhoVendaAtacado.getRowCount() != contador) {
											try {
												String query = "INSERT INTO adegagelaguela.venda (Cliente_idCliente, Carrinho_idCarrinho, FormaDePgmt, PagamentoFuturo) VALUES (?, ?, ?, ?)";
												PreparedStatement pst = conexao.prepareStatement(query);
												pst.setString(1, txtIdDoClienteVendaAtacado.getText());
												pst.setString(2, tableProdutosNoCarrinhoVendaAtacado.getValueAt(contador, 0).toString());
												pst.setString(3, "Cartão");
												pst.setString(4, "SIM");
												pst.execute();
												pst.close();
												contador++;
											} catch (Exception g) {
												g.printStackTrace();
											}	
							}JOptionPane.showMessageDialog(null, "Venda Realizada!", "", JOptionPane.INFORMATION_MESSAGE);
						
						}
					}
				}
			}
		});
		btnNewButtonVenderVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		vendaAtacado.add(btnNewButtonVenderVendaAtacado);
		
		JLabel lblNewLabel_4 = new JLabel("Desconto R$:");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\ios7-stock-icon.png"));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(518, 259, 115, 41);
		vendaAtacado.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(642, 270, 117, 20);
		vendaAtacado.add(textField);
		textField.setColumns(10);


		//
		//
		//VENDA PERSONALIZADA
		//
		//

		JMenuBar menuBarVendaPersonalizada = new JMenuBar();
		menuBarVendaPersonalizada.setBounds(0, 0, 934, 22);
		menuBarVendaPersonalizada.setBackground(Color.LIGHT_GRAY);
		vendaPersonalizada.add(menuBarVendaPersonalizada);

		JMenu mnProdutosVendaPersonalizada = new JMenu("Produtos");
		mnProdutosVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarVendaPersonalizada.add(mnProdutosVendaPersonalizada);

		JMenuItem mntmProdutosNaAdegaVendaPersonalizada = new JMenuItem("Produtos na Adega");
		mntmProdutosNaAdegaVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(true);
				vendaPersonalizada.setVisible(false);
			}
		});
		mntmProdutosNaAdegaVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosVendaPersonalizada.add(mntmProdutosNaAdegaVendaPersonalizada);

		JMenuItem mntmProdutosEmEstoqueVendaPersonalizada = new JMenuItem("Produtos Em Estoque");
		mntmProdutosEmEstoqueVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaPersonalizada.setVisible(false);
				produtosEmEstoque.setVisible(true);
			}
		});
		mntmProdutosEmEstoqueVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosVendaPersonalizada.add(mntmProdutosEmEstoqueVendaPersonalizada);

		JMenuItem mntmTodosOsProdutosVendaPersonalizada;
		mntmTodosOsProdutosVendaPersonalizada = new JMenuItem("Todos Produtos");
		mntmTodosOsProdutosVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmTodosOsProdutosVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosVendaPersonalizada.add(mntmTodosOsProdutosVendaPersonalizada);

		JMenuItem mntmProdutosParaComprarVendaPersonalizada = new JMenuItem("Produtos para Comprar");
		mntmProdutosParaComprarVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaPersonalizada.setVisible(false);
				produtosParaComprar.setVisible(true);
			}
		});
		mntmProdutosParaComprarVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		mnProdutosVendaPersonalizada.add(mntmProdutosParaComprarVendaPersonalizada);

		JMenu mnVenderVendaPersonalizada = new JMenu("Vender");
		mnVenderVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarVendaPersonalizada.add(mnVenderVendaPersonalizada);

		JMenuItem mntmVendaVarejoVendaPersonalizada = new JMenuItem("Venda Varejo");
		mntmVendaVarejoVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaPersonalizada.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmVendaVarejoVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderVendaPersonalizada.add(mntmVendaVarejoVendaPersonalizada);

		JMenuItem mntmVendaPersonalizada = new JMenuItem("Venda Personalizada");
		mntmVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaPersonalizada.setVisible(false);
				vendaPersonalizada.setVisible(true);
			}
		});
		mntmVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
		mnVenderVendaPersonalizada.add(mntmVendaPersonalizada);

		
		JMenuItem mntmVendaAtacadoVendaPersonalizada = new JMenuItem("Venda Atacado");
		mntmVendaAtacadoVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmVendaAtacadoVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderVendaPersonalizada.add(mntmVendaAtacadoVendaPersonalizada);
		
		JMenu mnFinanceiroVendaPersonalizada = new JMenu("Financeiro");
		mnFinanceiroVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\US-dollar-icon (1).png"));
		menuBarVendaPersonalizada.add(mnFinanceiroVendaPersonalizada);

		JMenu mnAjudaVendaPersonalizada = new JMenu("Ajuda");
		mnAjudaVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarVendaPersonalizada.add(mnAjudaVendaPersonalizada);

		JMenuItem mntmDadosDaVersaoVendaPersonalizada = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaVendaPersonalizada.add(mntmDadosDaVersaoVendaPersonalizada);
		


		//
		//
		// TELA DE LOGIN
		//
		//
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(Color.DARK_GRAY);
		btnEntrar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_NUMPAD1) {
					btnEntrar.addActionListener(new ActionListener() {
						@SuppressWarnings("deprecation")
						public void actionPerformed(ActionEvent e) {
							if (checkLogin(textLogin.getText(), new String(txtSenha.getText()))) {
								menuInicial.setVisible(true);
								telaDeLogin.setVisible(false);
								mntmProdutosEmEstoqueMenuInicial.setVisible(false);
								mntmProdutosParaComprarMenuInicial.setVisible(false);
								mntmProdutosEmEstoqueProdutosNaAdega.setVisible(false);
								mntmProdutosParaComprarProdutosNaAdega.setVisible(false);
								mntmTodosOsProdutosProdutosEmEstoque.setVisible(false);
								mntmProdutosParaComprarProdutosNaAdega.setVisible(false);
								mntmTodosOsProdutosProdutosParaComprar.setVisible(false);
								mnFinanceiroMenuInicial.setVisible(false);
								mntmVendaAtacadoMenuInicial.setVisible(false);
								mntmVendaPersonalizadaMenuInicial.setVisible(false);
								mnFinanceiroProdutosNaAdega.setVisible(false);
								mntmVendaAtacadoProdutosNaAdega.setVisible(false);
								mntmVendaPersonalizadaProdutosNaAdega.setVisible(false);
								mnFinanceiroTodosOsProdutos.setVisible(false);
								mntmVendaAtacadoTodosOsProdutos.setVisible(false);
								mntmVendaPersonalizadaTodosOsProdutos.setVisible(false);
								btnEntrar.getRootPane().setDefaultButton(btnEntrar);
							} else if (checkLoginADM(textLogin.getText(), new String(txtSenha.getText()))) {
								menuInicial.setVisible(true);
								telaDeLogin.setVisible(false);
								mntmProdutosNaAdegaMenuInicial.setVisible(false);
								btnEntrar.getRootPane().setDefaultButton(btnEntrar);
							} else {
								JOptionPane.showMessageDialog(null, "Dados inválidos!", "ERRO!!", JOptionPane.ERROR_MESSAGE);
							}

						}
					});
				}
			}
		});
		btnEntrar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-dialog-ok-apply-icon.png"));
		btnEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (checkLogin(textLogin.getText(), new String(txtSenha.getText()))) {
					menuInicial.setVisible(true);
					telaDeLogin.setVisible(false);
					mntmProdutosEmEstoqueMenuInicial.setVisible(false);
					mntmProdutosParaComprarMenuInicial.setVisible(false);
					mntmProdutosEmEstoqueProdutosNaAdega.setVisible(false);
					mntmProdutosParaComprarProdutosNaAdega.setVisible(false);
					mntmTodosOsProdutosProdutosEmEstoque.setVisible(false);
					mntmProdutosParaComprarProdutosNaAdega.setVisible(false);
					mntmTodosOsProdutosProdutosParaComprar.setVisible(false);
					mnFinanceiroMenuInicial.setVisible(false);
					mntmVendaAtacadoMenuInicial.setVisible(false);
					mntmVendaPersonalizadaMenuInicial.setVisible(false);
					mnFinanceiroProdutosNaAdega.setVisible(false);
					mntmVendaAtacadoProdutosNaAdega.setVisible(false);
					mntmVendaPersonalizadaProdutosNaAdega.setVisible(false);
					mnFinanceiroTodosOsProdutos.setVisible(false);
					mntmVendaAtacadoTodosOsProdutos.setVisible(false);
					mntmVendaPersonalizadaTodosOsProdutos.setVisible(false);
					btnEntrar.getRootPane().setDefaultButton(btnEntrar);
				} else if (checkLoginADM(textLogin.getText(), new String(txtSenha.getText()))) {
					menuInicial.setVisible(true);
					telaDeLogin.setVisible(false);
					btnEntrar.getRootPane().setDefaultButton(btnEntrar);
					
				} else {
					JOptionPane.showMessageDialog(null, "Dados inválidos!", "ERRO!!", JOptionPane.ERROR_MESSAGE);
				}

			}
			@SuppressWarnings("unused")
			public void keyPressed(KeyEvent e) {
				btnEntrar.getRootPane().setDefaultButton(btnEntrar);
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setBounds(465, 221, 101, 20);
		telaDeLogin.add(btnEntrar);

		JLabel lblNewLabelLogin = new JLabel("Login");
		lblNewLabelLogin.setForeground(Color.WHITE);
		lblNewLabelLogin.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		lblNewLabelLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabelLogin.setBounds(359, 150, 83, 23);
		telaDeLogin.add(lblNewLabelLogin);

		textLogin = new JTextField();
		textLogin.setSelectionColor(Color.WHITE);
		textLogin.setOpaque(false);
		textLogin.setBounds(444, 150, 145, 23);
		telaDeLogin.add(textLogin);
		textLogin.setColumns(10);

		JLabel lblNewLabelSenha = new JLabel("Senha");
		lblNewLabelSenha.setForeground(Color.WHITE);
		lblNewLabelSenha.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\key-icon (1).png"));
		lblNewLabelSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabelSenha.setBounds(359, 190, 83, 20);
		telaDeLogin.add(lblNewLabelSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setOpaque(false);
		txtSenha.setForeground(Color.WHITE);
		txtSenha.setSelectionColor(Color.WHITE);
		txtSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txtSenha.getRootPane().setDefaultButton(btnEntrar);
			}
		});
		txtSenha.setBackground(Color.WHITE);
		txtSenha.setEchoChar('*');
		txtSenha.setColumns(10);
		txtSenha.setBounds(444, 190, 145, 20);
		telaDeLogin.add(txtSenha);

		JLabel lblNewLabelImagemDeFundo = new JLabel("");
		lblNewLabelImagemDeFundo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Blue-Label-e1489370807665.jpg"));
		lblNewLabelImagemDeFundo.setBounds(0, -22, 789, 630);
		telaDeLogin.add(lblNewLabelImagemDeFundo);

	}

	public boolean checkLogin(String login, String senha) {
		return login.equals("user") && senha.equals("123");
	}
	public boolean checkLoginADM(String login, String senha) {
		return login.equals("1") && senha.equals("1");
	}
	
	@SuppressWarnings("deprecation")
	public String admSenha() {
		JPasswordField jpf = new JPasswordField(4);
		 jpf.setEchoChar('*');
		 JLabel jl = new JLabel("Digite a senha: ");
		 Box box = Box.createHorizontalBox();
		 box.add(jl);
		 box.add(jpf);
		JOptionPane.showConfirmDialog(null, box, "", JOptionPane.OK_CANCEL_OPTION);
		return jpf.getText().toString();
	}
	//
	//
	// RefreshTables & metodos
	//
	//
	public void refreshtableProdutosNaAdega() {
		try {
			String query = "SELECT Id 'ID', Nome 'Nome do Produto', Unidades, Preco 'Preço por Un', PrecoTotal 'Valor total' FROM adegagelaguela.lojaTatuape ORDER BY Nome";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tableProdutosNaAdega.setModel(DbUtils.resultSetToTableModel(rs));

			pst.close();
			rs.close();

		} catch (Exception g) {
			g.printStackTrace();
		}
	}

	public void refreshtableProdutosEmEstoque() {
		try {
			String query = "SELECT idEstoque 'ID', Produto, UnidadesSoltas 'Unidades', Caixas 'Caixas', UnidadeEmCadaCaixa 'Un p/ Cx', QuantidadeAtual 'Quantia Atual', PrecoDeCusto 'Preço UN', ValorTotal 'Valor Total' FROM adegagelaguela.estoque ORDER BY Produto";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tableProdutosEmEstoque.setModel(DbUtils.resultSetToTableModel(rs));

			pst.close();
			rs.close();

		} catch (Exception g) {
			g.printStackTrace();
		}
	}

	public void refreshtableProdutosParaComprar() {
		try {
			String query = "SELECT IDParaCompra 'ID', Nome, QuantidadeUn 'Quantidade UN', Preco 'Preço', ValorDeCompra 'Total da compra' FROM adegagelaguela.produtosparacomprar ORDER BY Nome";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tableProdutosParaComprar.setModel(DbUtils.resultSetToTableModel(rs));

			pst.close();
			rs.close();

		} catch (Exception g) {
			g.printStackTrace();
		}
	}
	public void refreshtableTodosOsProdutos() {
		try {
			String query = "SELECT * FROM adegagelaguela.todosprodutos ORDER BY Produto";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tableTodosProdutos.setModel(DbUtils.resultSetToTableModel(rs));

			pst.close();
			rs.close();

		} catch (Exception g) {
			g.printStackTrace();
		}
	}
	public void refreshTableClientesVendaAtacado() {
		try {
			String query = "SELECT idCliente 'ID', Nome 'Cliente', Empresa FROM adegagelaguela.cliente";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tableClientesVendaAtacado_1.setModel(DbUtils.resultSetToTableModel(rs));

			pst.close();
			rs.close();

		} catch (Exception g) {
			g.printStackTrace();
		}
	}
	public void refreshtableCarrinhoVendaAtacado() {
		try {
			String query = "SELECT adegagelaguela.carrinho.idCarrinho 'ID', adegagelaguela.estoque.Produto, adegagelaguela.carrinho.QuantidadeAVender 'Quantidade', adegagelaguela.carrinho.PrecoDeVenda 'Preco Unidade' FROM adegagelaguela.carrinho "
					+ "JOIN adegagelaguela.estoque ON adegagelaguela.carrinho.Estoque_idEstoque = adegagelaguela.estoque.idEstoque;";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tableProdutosNoCarrinhoVendaAtacado.setModel(DbUtils.resultSetToTableModel(rs));

			String query2 = "SELECT SUM(PrecoTotal) as soma FROM carrinho";
			PreparedStatement pst2 = conexao.prepareStatement(query2);
			ResultSet rs2 = pst2.executeQuery();
			tablePrecoTotal.setModel(DbUtils.resultSetToTableModel(rs2));
			textFieldPrecoTotalVendaAtacado.setText("R$: " + tablePrecoTotal.getValueAt(0, 0).toString()+ "0");
			pst.close();
			rs.close();
			pst2.close();
			rs2.close();
		} catch (Exception g) {
			g.printStackTrace();
		}
	}
}