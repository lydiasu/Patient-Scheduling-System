package edu.miami.cis324.hw4.ysu;


import java.awt.Color;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.xml.stream.XMLStreamException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import java.awt.Font;

public class PatientScheduling extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	private final static String INPUT_FILE = "/Users/suyuqing/Desktop/Final Project/resources/schedulerData.xml";
	
	private JPanel contentPane;
	private JTextField tfPFname;
	private JTextField textFieldPLname;
	private JTextField textField_PID;
	private JTextField textField_PEmail;
	private JTextField textField_PDob;
	private JTextField textField_DFname;
	private JTextField textField_DLname;
	private JTextField textField_DID;
	private JTextField textField_DEmail;
	private JTextField textField_DDob;
	private JTextField textField_Specialty;
	private JTable Ptable;
	private JTable Dtable;


	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientScheduling frame = new PatientScheduling();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws XMLStreamException 
	 */
	
	    
	public PatientScheduling() throws XMLStreamException, IOException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1500, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		SchedulerData ss = SchedulerXMLReaderUtils.readSchedulingXML(INPUT_FILE);
		
		JComboBox<String> comboBoxPatient = new JComboBox<String>();
		
		comboBoxPatient.setBounds(24, 34, 333, 58);
		contentPane.add(comboBoxPatient);
	
		
		JLabel lblPFName = new JLabel("First Name:");
		lblPFName.setBounds(34, 92, 141, 29);
		contentPane.add(lblPFName);
		
		JLabel labelPLname = new JLabel("Last Name:");
		labelPLname.setBounds(34, 133, 141, 29);
		contentPane.add(labelPLname);
		
		JLabel lblPId = new JLabel("ID:");
		lblPId.setBounds(34, 174, 141, 29);
		contentPane.add(lblPId);
		
		JLabel lblPEmail = new JLabel("Email:");
		lblPEmail.setBounds(34, 209, 141, 29);
		contentPane.add(lblPEmail);
		
		JLabel lblPDateOfBirth = new JLabel("Date of Birth:");
		lblPDateOfBirth.setBounds(34, 250, 141, 29);
		contentPane.add(lblPDateOfBirth);
		
		JLabel lblDFname = new JLabel("First Name:");
		lblDFname.setBounds(34, 385, 141, 29);
		contentPane.add(lblDFname);
		
		JLabel lblDLname = new JLabel("Last Name:");
		lblDLname.setBounds(34, 426, 141, 29);
		contentPane.add(lblDLname);
		
		JLabel lblDid = new JLabel("ID:");
		lblDid.setBounds(34, 467, 141, 29);
		contentPane.add(lblDid);
		
		JLabel lblDSsn = new JLabel("Email:");
		lblDSsn.setBounds(34, 502, 141, 29);
		contentPane.add(lblDSsn);
		
		JLabel lblDDateofBirth = new JLabel("Date of Birth:");
		lblDDateofBirth.setBounds(34, 543, 141, 29);
		contentPane.add(lblDDateofBirth);
		
		tfPFname = new JTextField();
		tfPFname.setEditable(false);
		tfPFname.setBounds(142, 92, 215, 29);
		contentPane.add(tfPFname);
		tfPFname.setColumns(10);
		
		textFieldPLname = new JTextField();
		textFieldPLname.setEditable(false);
		textFieldPLname.setColumns(10);
		textFieldPLname.setBounds(142, 133, 215, 29);
		contentPane.add(textFieldPLname);
		
		textField_PID = new JTextField();
		textField_PID.setEditable(false);
		textField_PID.setColumns(10);
		textField_PID.setBounds(142, 174, 215, 29);
		contentPane.add(textField_PID);
		
		textField_PEmail = new JTextField();
		textField_PEmail.setEditable(false);
		textField_PEmail.setColumns(10);
		textField_PEmail.setBounds(142, 215, 215, 29);
		contentPane.add(textField_PEmail);
		
		textField_PDob = new JTextField();
		textField_PDob.setEditable(false);
		textField_PDob.setColumns(10);
		textField_PDob.setBounds(142, 250, 215, 29);
		contentPane.add(textField_PDob);
		
		textField_DFname = new JTextField();
		textField_DFname.setEditable(false);
		textField_DFname.setColumns(10);
		textField_DFname.setBounds(142, 385, 215, 29);
		contentPane.add(textField_DFname);
		
		textField_DLname = new JTextField();
		textField_DLname.setEditable(false);
		textField_DLname.setColumns(10);
		textField_DLname.setBounds(142, 426, 215, 29);
		contentPane.add(textField_DLname);
		
		textField_DID = new JTextField();
		textField_DID.setEditable(false);
		textField_DID.setColumns(10);
		textField_DID.setBounds(142, 467, 215, 29);
		contentPane.add(textField_DID);
		
		textField_DEmail = new JTextField();
		textField_DEmail.setEditable(false);
		textField_DEmail.setColumns(10);
		textField_DEmail.setBounds(142, 508, 215, 29);
		contentPane.add(textField_DEmail);
		
		textField_DDob = new JTextField();
		textField_DDob.setEditable(false);
		textField_DDob.setColumns(10);
		textField_DDob.setBounds(142, 543, 215, 29);
		contentPane.add(textField_DDob);
		
		JLabel lblSpecialty = new JLabel("Specialty:");
		lblSpecialty.setBounds(34, 589, 141, 29);
		contentPane.add(lblSpecialty);
		
		textField_Specialty = new JTextField();
		textField_Specialty.setEditable(false);
		textField_Specialty.setColumns(10);
		textField_Specialty.setBounds(142, 589, 215, 29);
		contentPane.add(textField_Specialty);
		
		
		
		JComboBox<String> comboBoxDoctor = new JComboBox<String>();
		
		comboBoxDoctor.setBounds(24, 326, 333, 58);
		contentPane.add(comboBoxDoctor);
		
		
		JLabel lblPName = new JLabel("");
		lblPName.setBounds(1049, 34, 191, 46);
		lblPName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(lblPName);
		
		
		
		JLabel lblDName = new JLabel("");
		lblDName.setBounds(1049, 338, 191, 46);
		lblDName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(lblDName);
		
		
		
		
		JLabel lblUpcomingVisitsFor = new JLabel("Upcoming Visits For Patient:");
		lblUpcomingVisitsFor.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblUpcomingVisitsFor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUpcomingVisitsFor.setBounds(610, 34, 403, 46);
		contentPane.add(lblUpcomingVisitsFor);
	
		
		
		
		JLabel lblUpcomingVisitsFor_1 = new JLabel("Upcoming Visits For Doctor:");
		lblUpcomingVisitsFor_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUpcomingVisitsFor_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblUpcomingVisitsFor_1.setBounds(610, 338, 403, 46);
		contentPane.add(lblUpcomingVisitsFor_1);
		
		Ptable = new JTable();
		Ptable.setBounds(517, 92, 790, 235);
		Ptable.setBackground(new Color(245, 255, 250));
		Ptable.setSelectionBackground(Color.BLUE);
		Ptable.setSelectionForeground(Color.WHITE);
		Ptable.setRowHeight(30);
		Ptable.setRowMargin(5);
		Ptable.setGridColor(Color.GRAY);
		contentPane.add(Ptable);
		
		DefaultTableModel model1 = new DefaultTableModel();
		
		String ColumnNames[] = {"Visit Date", "Doctor", "Email", "Specialty", "Days Until Visit"};
		
		model1.setColumnIdentifiers(ColumnNames);
		
		model1.addRow(ColumnNames);
		
		Ptable.setModel(model1);
		
		contentPane.add(Ptable);
		
		Dtable = new JTable();
		Dtable.setBounds(517, 392, 790, 235);
		Dtable.setBackground(new Color(245, 255, 250));	
		Dtable.setSelectionBackground(Color.BLUE);
		Dtable.setSelectionForeground(Color.WHITE);
		Dtable.setGridColor(Color.GRAY);
		Dtable.setRowHeight(30);
		Dtable.setRowMargin(5);
		contentPane.add(Dtable);
		

		DefaultTableModel model2 = new DefaultTableModel();
		
		String ColumnNames1[] = {"Visit Date", "Patient", "Email", "Age", "Days Until Visit"};
		
		model2.setColumnIdentifiers(ColumnNames1);
		
		model2.addRow(ColumnNames1);
		
		Dtable.setModel(model2);
		
		contentPane.add(Dtable);
			
			comboBoxPatient.addItem("Patient");
			
			for (int i = 0; i < ss.getPatientList().size(); i++)
			{
				comboBoxPatient.addItem(ss.getPatientList().get(i).getPatientName());
			}
			
			comboBoxDoctor.addItem("Doctor");
			
			for (int i = 0; i < ss.getDoctorList().size(); i++)
			{
				comboBoxDoctor.addItem(ss.getDoctorList().get(i).getDoctorName());
			}
	
		comboBoxPatient.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(Ptable.getRowCount() > 1)
				{
					for(int i = 0; i <= Ptable.getRowCount(); i++)
					{
						if(Ptable.getRowCount() > 1)
						{
							model1.removeRow(1);
						}
					}
				}
					
					if(comboBoxPatient.getSelectedItem().equals("Patient"))
					{
						tfPFname.setText("");
			
						textFieldPLname.setText("");
						textField_PID.setText("");
						
						textField_PEmail.setText("");
						
						textField_PDob.setText("");
						
					}
					else{
					 
						for (int i = 0; i < ss.getPatientList().size(); i++)
						{
							if(comboBoxPatient.getSelectedItem().equals(ss.getPatientList().get(i).getPatientName()))
							{
								tfPFname.setText(ss.getPatientList().get(i).getPatientFname());
								
								textFieldPLname.setText(ss.getPatientList().get(i).getPatientLname());
							
								textField_PID.setText(Integer.toString(ss.getPatientList().get(i).getPatientID()));
							
								textField_PEmail.setText(ss.getPatientList().get(i).getEmail());
							
								textField_PDob.setText(XMLReaderUtils.DateToString("yyyy-MM-dd", ss.getPatientList().get(i).getDob()));
							
							
							}
						
						}
				
					}
				
			}
		});
		
		
		comboBoxDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(Dtable.getRowCount() > 1)
				{
					for(int i = 0; i <= Dtable.getRowCount(); i++)
					{
						if(Dtable.getRowCount() > 1)
						{
							model2.removeRow(1);
						}
					}
				}
						
						
						
						if(comboBoxDoctor.getSelectedItem().equals("Doctor"))
						{
							textField_DFname.setText("");
				
							textField_DLname.setText("");
							textField_DID.setText("");
							
							textField_DEmail.setText("");
							
							textField_DDob.setText("");
							
							textField_Specialty.setText("");
							
						}
						else{
							
							for (int j = 0; j < ss.getDoctorList().size();j++)
							{
								if(comboBoxDoctor.getSelectedItem().equals(ss.getDoctorList().get(j).getDoctorName()))
								{
								textField_DFname.setText(ss.getDoctorList().get(j).getDoctorFname());
								textField_DLname.setText(ss.getDoctorList().get(j).getDoctorLname());
								textField_DID.setText(Integer.toString(ss.getDoctorList().get(j).getDoctorID()));;
								textField_DEmail.setText(ss.getDoctorList().get(j).getEmail());
								textField_DDob.setText(XMLReaderUtils.DateToString("yyyy-MM-dd",ss.getDoctorList().get(j).getDob()));
								textField_Specialty.setText(ss.getDoctorList().get(j).getSpecialty().toString());
								}
							}
						
						}
			}
		});
		

		
		JButton btnPVisits = new JButton("Show All Patient Upcoming Visits");
		
		btnPVisits.setBounds(61, 292, 269, 29);
		contentPane.add(btnPVisits);
		
	
		btnPVisits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			
				if(!comboBoxPatient.getSelectedItem().equals("Patient"))	
				{		
					if(comboBoxPatient.getSelectedItem().toString() != lblPName.getText())
					{
						lblPName.setText(comboBoxPatient.getSelectedItem().toString());
						
						Map<Integer, Doctor> doctorIdMap = new HashMap<Integer, Doctor>(); 
						Map<Integer, Patient> patientIdMap = new HashMap<Integer, Patient>();
						
						
						for(int j = 0; j < ss.getPatientList().size(); j++)
						 {
							 doctorIdMap.put(ss.getDoctorList().get(j).getDoctorID(), ss.getDoctorList().get(j));
						 }
						
						for (int i = 0; i < ss.getDoctorList().size(); i++)
						 {	
							
							 patientIdMap.put(ss.getPatientList().get(i).getPatientID(), ss.getPatientList().get(i));
							
						  	
						 }
						
						
						String[] pVisit = new String[ColumnNames.length];
				
						
						 Collections.sort(ss.getVisitList(),new VisitComparator<Integer,Integer>());
						 

							for(int k = 0; k < ss.getVisitList().size(); k++)
							{
								 Date today = new Date();
								 
								 if(ss.getVisitList().get(k).getDateOfVisit().compareTo(today) > 0)
								 {
									for(Integer key: patientIdMap.keySet())
									{
										if(lblPName.getText().equals(patientIdMap.get(key).getPatientName()))
										{	
										 
												if( patientIdMap.get(key).getPatientID() == ss.getVisitList().get(k).getVisitor())
												{
													pVisit[0] = XMLReaderUtils.DateToString("MMMM dd yyyy", ss.getVisitList().get(k).getDateOfVisit());
											 
													pVisit[1] = doctorIdMap.get(ss.getVisitList().get(k).getHost()).getDoctorName();
											 
													pVisit[2] = doctorIdMap.get(ss.getVisitList().get(k).getHost()).getEmail();
											
											 
													pVisit[3] = doctorIdMap.get(ss.getVisitList().get(k).getHost()).getSpecialty().toString();
											 
													long days = XMLReaderUtils.differenceBetweenDates(today, ss.getVisitList().get(k).getDateOfVisit());
											 
													pVisit[4] = Long.toString(days);
											 
													model1.addRow(pVisit);
											 
													Ptable.setModel(model1);
											
												}
										 
											
										}
									 }
								 }
							}
						}
				
					}
			
					else
					{
						JOptionPane.showMessageDialog(null, "Please select a patient.");
					}
						
					
				
			}
		});
		
		
		
		
		JButton btnDVisits = new JButton("Show All Doctor Upcoming Visits");
		btnDVisits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!comboBoxDoctor.getSelectedItem().equals("Doctor"))
				{	
					if(comboBoxDoctor.getSelectedItem().toString() != lblDName.getText())
					{
				
					lblDName.setText(comboBoxDoctor.getSelectedItem().toString());
			 
					 String[] dVisit = new String[ColumnNames1.length];
					
					 Collections.sort(ss.getVisitList(),new VisitComparator<Integer,Integer>());
					 
					 Map<Integer, Doctor> doctorIdMap = new HashMap<Integer, Doctor>(); 
						Map<Integer, Patient> patientIdMap = new HashMap<Integer, Patient>();
						
						
						for(int j = 0; j < ss.getDoctorList().size(); j++)
						 {
							 doctorIdMap.put(ss.getDoctorList().get(j).getDoctorID(), ss.getDoctorList().get(j));
						 }
						
						for (int i = 0; i < ss.getDoctorList().size(); i++)
						 {	
							
							 patientIdMap.put(ss.getPatientList().get(i).getPatientID(), ss.getPatientList().get(i));
							
						  	
						 }
						
						for(int k = 0; k < ss.getVisitList().size(); k++)
						{
							 Date today = new Date();
							 
							 if(ss.getVisitList().get(k).getDateOfVisit().compareTo(today) > 0)
							 {
								 for(Integer key: doctorIdMap.keySet())
								 {	 
									 if(lblDName.getText().equals(doctorIdMap.get(key).getDoctorName()))
									 {
									 if(doctorIdMap.get(key).getDoctorID() == ss.getVisitList().get(k).getHost())
									 {
										 dVisit[0] = XMLReaderUtils.DateToString("MMMM dd yyyy", ss.getVisitList().get(k).getDateOfVisit());
										 
										 dVisit[1] = patientIdMap.get(ss.getVisitList().get(k).getVisitor()).getPatientName();
										 
										 dVisit[2] = patientIdMap.get(ss.getVisitList().get(k).getVisitor()).getEmail();
										 
										 int age = XMLReaderUtils.calculateAge(patientIdMap.get(ss.getVisitList().get(k).getVisitor()).getDob());
										 
										 dVisit[3] = Integer.toString(age);
										 
										 long days = XMLReaderUtils.differenceBetweenDates(today, ss.getVisitList().get(k).getDateOfVisit());
										 
										 dVisit[4] = Long.toString(days);
										 
										 model2.addRow(dVisit);
										 
										 Dtable.setModel(model2);
										
									 }
									 
									 }
								 }
							 }
						}
					}
				}
			
				else
				{
					JOptionPane.showMessageDialog(null, "Please select a doctor.");
				}
			}
		});
		btnDVisits.setBounds(61, 632, 269, 29);
		contentPane.add(btnDVisits);
	
		
	}
}
