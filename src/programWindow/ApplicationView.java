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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
	private JTextField txtUnidadeProdutosEmEstoque, textFieldCaixaProdutosEmEstoque, textFieldPrecoProdutosEmEstoque, textFieldUnidadeNaCaixa, textFieldNomeProdutosEmEstoque, textFieldIdProdutosEmEstoque;


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
		vendaAtacado.setLayout(null);

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

		tableProdutosNaAdega = new JTable();
		scrollPaneProdutosNaAdega.setViewportView(tableProdutosNaAdega);

		JButton btnListarProdutosNaAdega = new JButton("Mostrar Produtos da Adega");
		btnListarProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM gelaguela.lojaTatuape";
					PreparedStatement pst = conexao.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					tableProdutosNaAdega.setModel(DbUtils.resultSetToTableModel(rs));

					pst.close();
					rs.close();

				} catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		btnListarProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-And-Pretzel-icon.png"));
		btnListarProdutosNaAdega.setBounds(402, 33, 252, 33);
		produtosNaAdega.add(btnListarProdutosNaAdega);

		JLabel lblIdProdutosNaAdega = new JLabel("ID do Produto : ");
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
				try {
					String query = "insert into lojaTatuape (Id, Nome, Unidades, Preço) values (?, ?, ?, ?)";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.setString(1, textFieldIdProdutosNaAdega.getText());
					pst.setString(2, textFieldNomeProdutosNaAdega.getText());
					pst.setString(3, textFieldQuantidadeProdutosNaAdega.getText());
					pst.setString(4, textFieldPrecoProdutosNaAdega.getText());
					pst.execute();

					JOptionPane.showMessageDialog(null, "Salvo com sucesso !");

					pst.close();
				} catch (Exception g) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
				}
				refreshtableProdutosNaAdega();
			}
		});
		btnAdicionarProdutosNaAdega
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		btnAdicionarProdutosNaAdega.setBounds(85, 225, 113, 25);
		produtosNaAdega.add(btnAdicionarProdutosNaAdega);

		JButton btnAtualizarProdutosNaAdega = new JButton("Atualizar");
		btnAtualizarProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "Update lojaTatuape set Id='" + textFieldIdProdutosNaAdega.getText() + "' ,nome = '"
							+ textFieldNomeProdutosNaAdega.getText() + "' ,Unidades = '"
							+ textFieldQuantidadeProdutosNaAdega.getText() + "' ,preço = '"
							+ textFieldPrecoProdutosNaAdega.getText() + "' where Id='"
							+ textFieldIdProdutosNaAdega.getText() + "'  ";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.execute();

					JOptionPane.showMessageDialog(null, "Atualizado com sucesso !");

					pst.close();
				} catch (Exception g) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
				}
				refreshtableProdutosNaAdega();
			}
		});
		btnAtualizarProdutosNaAdega.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Files-Check-File-icon.png"));
		btnAtualizarProdutosNaAdega.setBounds(85, 260, 113, 25);
		produtosNaAdega.add(btnAtualizarProdutosNaAdega);

		JButton btnDeletarProdutosNaAdega = new JButton("Deletar");
		btnDeletarProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "delete from lojaTatuape where Id='" + textFieldIdProdutosNaAdega.getText() + "' ";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Produto Deletado !", "", JOptionPane.ERROR_MESSAGE);
					pst.close();
				} catch (Exception g) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
				}
				refreshtableProdutosNaAdega();
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
		lblNewLabel_Fundo1.setBounds(363, 329, 419, 227);
		produtosNaAdega.add(lblNewLabel_Fundo1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\FundoDaJackApple2jpg.jpg"));
		lblNewLabel_6.setBounds(412, -66, 379, 402);
		produtosNaAdega.add(lblNewLabel_6);
		telaDeLogin.setLayout(null);


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

		tableProdutosEmEstoque = new JTable();
		scrollPaneProdutosEmEstoque.setViewportView(tableProdutosEmEstoque);

		JButton btnListarProdutosEmEstoque = new JButton("Mostrar Produtos no Estoque");
		btnListarProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM gelaguela.estoque";
					PreparedStatement pst = conexao.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					tableProdutosEmEstoque.setModel(DbUtils.resultSetToTableModel(rs));

					pst.close();
					rs.close();

				} catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		btnListarProdutosEmEstoque.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\62894-package-icon.png"));
		btnListarProdutosEmEstoque.setBounds(325, 33, 252, 25);
		produtosEmEstoque.add(btnListarProdutosEmEstoque);

		JLabel lblIdProdutosEmEstoque = new JLabel("ID do Produto : ");
		lblIdProdutosEmEstoque.setForeground(Color.WHITE);
		lblIdProdutosEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdProdutosEmEstoque.setBounds(236, 85, 97, 20);
		produtosEmEstoque.add(lblIdProdutosEmEstoque);

		JLabel lblNomeProdutosEmEstoque = new JLabel("Nome do Produto :");
		lblNomeProdutosEmEstoque.setForeground(Color.WHITE);
		lblNomeProdutosEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeProdutosEmEstoque.setBounds(417, 84, 129, 20);
		produtosEmEstoque.add(lblNomeProdutosEmEstoque);

		JLabel lblPrecoProdutosEmEstoque = new JLabel("Pre\u00E7o :");
		lblPrecoProdutosEmEstoque.setForeground(Color.WHITE);
		lblPrecoProdutosEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecoProdutosEmEstoque.setBounds(612, 120, 48, 20);
		produtosEmEstoque.add(lblPrecoProdutosEmEstoque);

		textFieldIdProdutosEmEstoque = new JTextField();
		textFieldIdProdutosEmEstoque.setBounds(340, 85, 40, 20);
		produtosEmEstoque.add(textFieldIdProdutosEmEstoque);
		textFieldIdProdutosEmEstoque.setColumns(10);

		textFieldNomeProdutosEmEstoque = new JTextField();
		textFieldNomeProdutosEmEstoque.setBounds(536, 86, 196, 20);
		produtosEmEstoque.add(textFieldNomeProdutosEmEstoque);
		textFieldNomeProdutosEmEstoque.setColumns(10);

		textFieldUnidadeNaCaixa = new JTextField();
		textFieldUnidadeNaCaixa.setBounds(536, 120, 40, 20);
		produtosEmEstoque.add(textFieldUnidadeNaCaixa);
		textFieldUnidadeNaCaixa.setColumns(10);

		textFieldPrecoProdutosEmEstoque = new JTextField();
		textFieldPrecoProdutosEmEstoque.setBounds(662, 120, 70, 20);
		produtosEmEstoque.add(textFieldPrecoProdutosEmEstoque);
		textFieldPrecoProdutosEmEstoque.setColumns(10);
		
		txtUnidadeProdutosEmEstoque = new JTextField();
		txtUnidadeProdutosEmEstoque.setCaretColor(Color.BLACK);
		txtUnidadeProdutosEmEstoque.setBounds(340, 120, 40, 20);
		produtosEmEstoque.add(txtUnidadeProdutosEmEstoque);
		txtUnidadeProdutosEmEstoque.setColumns(10);
		
		textFieldCaixaProdutosEmEstoque = new JTextField();
		textFieldCaixaProdutosEmEstoque.setBounds(340, 151, 40, 20);
		produtosEmEstoque.add(textFieldCaixaProdutosEmEstoque);
		textFieldCaixaProdutosEmEstoque.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Unidades soltas :");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(233, 120, 120, 20);
		produtosEmEstoque.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Quantidade de Caixas :");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(200, 151, 142, 20);
		produtosEmEstoque.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("Unidades por Caixa :");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(417, 120, 113, 20);
		produtosEmEstoque.add(lblNewLabel_7);
		telaDeLogin.setLayout(null);

		JButton btnAdicionarProdutosEmEstoque = new JButton("Adicionar");
		btnAdicionarProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into estoque (idEstoque, Nome, Unidade, Caixa, UnidadeNaCaixa, PrecoDeCusto) values (?, ?, ?, ?, ?, ?)";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.setString(1, textFieldIdProdutosEmEstoque.getText());
					pst.setString(2, textFieldNomeProdutosEmEstoque.getText());
					pst.setString(3, txtUnidadeProdutosEmEstoque.getText());
					pst.setString(4, textFieldCaixaProdutosEmEstoque.getText());
					pst.setString(5, textFieldUnidadeNaCaixa.getText());
					pst.setString(6, textFieldPrecoProdutosEmEstoque.getText());
					pst.execute();

					JOptionPane.showMessageDialog(null, "Salvo com sucesso !");

					pst.close();
				} catch (SQLException g) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
				}
				refreshtableProdutosEmEstoque();
			}
		});
		btnAdicionarProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		btnAdicionarProdutosEmEstoque.setBounds(409, 150, 113, 25);
		produtosEmEstoque.add(btnAdicionarProdutosEmEstoque);

		JButton btnAtualizarProdutosEmEstoque = new JButton("Atualizar");
		btnAtualizarProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "Update estoque set idEstoque='" + textFieldIdProdutosEmEstoque.getText() + "' ,Nome = '" + textFieldNomeProdutosEmEstoque.getText() + "' ,Unidade = '" + txtUnidadeProdutosEmEstoque.getText() + "' ,Caixa = '" + textFieldCaixaProdutosEmEstoque.getText() + "' ,UnidadeNaCaixa = '" + textFieldUnidadeNaCaixa.getText() + "' ,PrecoDeCusto = '"+ textFieldPrecoProdutosEmEstoque.getText() + "' where idEstoque='"+ textFieldIdProdutosEmEstoque.getText() + "'  ";
					if(textFieldIdProdutosEmEstoque.getText() != " " ||  textFieldNomeProdutosEmEstoque.getText() != null || textFieldPrecoProdutosEmEstoque.getText() != null ||textFieldCaixaProdutosEmEstoque.getText() != null ||txtUnidadeProdutosEmEstoque.getText() != null ||textFieldUnidadeNaCaixa.getText() != null) {
						JOptionPane.showMessageDialog(null, "Atualizado com sucesso !");
						PreparedStatement pst = conexao.prepareStatement(query);
						pst.execute();
						pst.close();
					}else
						JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); 
					
				} catch (Exception g) {
					g.printStackTrace();
					
				}
				refreshtableProdutosEmEstoque();
			}
		});
		btnAtualizarProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Files-Check-File-icon.png"));
		btnAtualizarProdutosEmEstoque.setBounds(536, 150, 113, 25);
		produtosEmEstoque.add(btnAtualizarProdutosEmEstoque);

		JButton btnDeletarProdutosEmEstoque = new JButton("Deletar");
		btnDeletarProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "delete from estoque where idEstoque='" + textFieldIdProdutosEmEstoque.getText() + "' ";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Produto Deletado !", "", JOptionPane.ERROR_MESSAGE);
					pst.close();
				} catch (Exception g) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
				}
				refreshtableProdutosEmEstoque();
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

		JScrollPane scrollPaneProdutosParaComprar = new JScrollPane();
		scrollPaneProdutosParaComprar.setBounds(270, 77, 504, 471);
		produtosParaComprar.add(scrollPaneProdutosParaComprar);

		tableProdutosParaComprar = new JTable();
		scrollPaneProdutosParaComprar.setViewportView(tableProdutosParaComprar);

		JButton btnListarProdutosParaComprar = new JButton("Mostrar Lista de Compras");
		btnListarProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM gelaguela.produtosparacomprar";
					PreparedStatement pst = conexao.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					tableProdutosParaComprar.setModel(DbUtils.resultSetToTableModel(rs));

					pst.close();
					rs.close();

				} catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		btnListarProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-down-icon.png"));
		btnListarProdutosParaComprar.setBounds(402, 33, 252, 33);
		produtosParaComprar.add(btnListarProdutosParaComprar);

		JLabel lblIdProdutosParaComprar = new JLabel("ID para Compra : ");
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

		JButton btnAdicionarProdutosParaComprar = new JButton("Adicionar");
		btnAdicionarProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into produtosparacomprar (IdParaCompra, Nome, QuantidadeCaixa, Preço) values (?, ?, ?, ?)";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.setString(1, textFieldIdProdutosParaComprar.getText());
					pst.setString(2, textFieldNomeProdutosParaComprar.getText());
					pst.setString(3, textFieldQuantidadeProdutosParaComprar.getText());
					pst.setString(4, textFieldPrecoProdutosParaComprar.getText());
					pst.execute();

					JOptionPane.showMessageDialog(null, "Salvo com sucesso !");

					pst.close();
				} catch (Exception g) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
				}
				refreshtableProdutosParaComprar();
			}
		});
		btnAdicionarProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		btnAdicionarProdutosParaComprar.setBounds(85, 225, 113, 25);
		produtosParaComprar.add(btnAdicionarProdutosParaComprar);

		JButton btnAtualizarProdutosParaComprar = new JButton("Atualizar");
		btnAtualizarProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "Update produtosparacomprar set IdParaCompra='" + textFieldIdProdutosParaComprar.getText()
							+ "' ,Nome = '" + textFieldNomeProdutosParaComprar.getText() + "' ,QuantidadeCaixa = '"
							+ textFieldQuantidadeProdutosParaComprar.getText() + "' ,Preço = '"
							+ textFieldPrecoProdutosParaComprar.getText() + "' where IdParaCompra='"
							+ textFieldIdProdutosParaComprar.getText() + "'  ";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.execute();

					JOptionPane.showMessageDialog(null, "Atualizado com sucesso !");

					pst.close();
				} catch (Exception g) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
				}
				refreshtableProdutosParaComprar();
			}
		});
		btnAtualizarProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Files-Check-File-icon.png"));
		btnAtualizarProdutosParaComprar.setBounds(85, 260, 113, 25);
		produtosParaComprar.add(btnAtualizarProdutosParaComprar);

		JButton btnDeletarProdutosParaComprar = new JButton("Deletar");
		btnDeletarProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "delete from produtosparacomprar where IdParaCompra='"
							+ textFieldIdProdutosParaComprar.getText() + "' ";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Produto Deletado !", "", JOptionPane.ERROR_MESSAGE);
					pst.close();
				} catch (Exception g) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
				}
				refreshtableProdutosParaComprar();
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

		tableTodosProdutos = new JTable();
		tableTodosProdutos.setSelectionBackground(Color.BLACK);
		tableTodosProdutos.setSelectionForeground(Color.BLACK);
		tableTodosProdutos.setOpaque(false);
		scrollPaneTodosOsProdutos.setViewportView(tableTodosProdutos);

		JButton btnListarTodosOsProdutos = new JButton("Mostrar Todos os Produtos");
		btnListarTodosOsProdutos.setBorder(UIManager.getBorder("CheckBox.border"));
		btnListarTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM gelaguela.todosprodutos";
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
					String query = "insert into todosprodutos (Id, Nome, Unidades) values (?, ?, ?)";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.setString(1, textFieldIdTodosOsProdutos.getText());
					pst.setString(2, textFieldNomeTodosOsProdutos.getText());
					pst.setString(3, textFieldQuantidadeTodosOsProdutos.getText());
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
				try {
					String query = "Update todosprodutos set Id='" + textFieldIdTodosOsProdutos.getText()+ "' ,nome = '" + textFieldNomeTodosOsProdutos.getText() + "' ,Unidades = '"+ textFieldQuantidadeTodosOsProdutos.getText() + "' ,preço = '" + "' where Id='"+ textFieldIdTodosOsProdutos.getText() + "'  ";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.execute();

					JOptionPane.showMessageDialog(null, "Atualizado com sucesso !");

					pst.close();
				} catch (Exception g) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
				}
				refreshtableTodosOsProdutos();
			}
		});
		btnAtualizarTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Files-Check-File-icon.png"));
		btnAtualizarTodosOsProdutos.setBounds(85, 260, 113, 25);
		todosProdutos.add(btnAtualizarTodosOsProdutos);

		JButton btnDeletarTodosOsProdutos = new JButton("Deletar");
		btnDeletarTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\e74e4d60430d27452f47f279859c921a.jpg"));
		lblNewLabel_1.setBounds(-129, 77, 435, 493);
		todosProdutos.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\52f47f279859c921a.jpg"));
		lblNewLabel.setBounds(0, 21, 782, 535);
		todosProdutos.add(lblNewLabel);
		telaDeLogin.setLayout(null);
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
		return login.equals("junior") && senha.equals("gabriela");
	}

	// RefreshTables
	public void refreshtableProdutosNaAdega() {
		try {
			String query = "SELECT * FROM gelaguela.produto";
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
			String query = "SELECT * FROM gelaguela.estoque";
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
			String query = "SELECT * FROM gelaguela.produtosparacomprar";
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
			String query = "SELECT * FROM gelaguela.produtosparacomprar";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tableTodosProdutos.setModel(DbUtils.resultSetToTableModel(rs));

			pst.close();
			rs.close();

		} catch (Exception g) {
			g.printStackTrace();
		}
	}
}