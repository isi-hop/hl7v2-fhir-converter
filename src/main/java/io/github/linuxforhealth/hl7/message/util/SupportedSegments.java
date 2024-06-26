package io.github.linuxforhealth.hl7.message.util;

import java.util.HashSet;
import java.util.Set;

public class SupportedSegments {
	private static Set<String> supportedSegment = new HashSet<String>();
	  
    static {
	    supportedSegment.add("ABS");
		supportedSegment.add("ACC");
		supportedSegment.add("ADD");
		supportedSegment.add("ADJ");
		supportedSegment.add("AFF");
		supportedSegment.add("AIG");
		supportedSegment.add("AIL");
		supportedSegment.add("AIP");
		supportedSegment.add("AIS");
		supportedSegment.add("AL1");
		supportedSegment.add("APR");
		supportedSegment.add("ARQ");
		supportedSegment.add("ARV");
		supportedSegment.add("AUT");
		supportedSegment.add("BHS");
		supportedSegment.add("BLC");
		supportedSegment.add("BLG");
		supportedSegment.add("BPO");
		supportedSegment.add("BPX");
		supportedSegment.add("BTS");
		supportedSegment.add("BTX");
		supportedSegment.add("CDM");
		supportedSegment.add("CER");
		supportedSegment.add("CM0");
		supportedSegment.add("CM1");
		supportedSegment.add("CM2");
		supportedSegment.add("CNS");
		supportedSegment.add("CON");
		supportedSegment.add("CSP");
		supportedSegment.add("CSR");
		supportedSegment.add("CSS");
		supportedSegment.add("CTD");
		supportedSegment.add("CTI");
		supportedSegment.add("DB1");
		supportedSegment.add("DG1");
		supportedSegment.add("DMI");
		supportedSegment.add("DRG");
		supportedSegment.add("DSC");
		supportedSegment.add("DSP");
		supportedSegment.add("ECD");
		supportedSegment.add("ECR");
		supportedSegment.add("EDU");
		supportedSegment.add("EQP");
		supportedSegment.add("EQU");
		supportedSegment.add("ERR");
		supportedSegment.add("EVN");
		supportedSegment.add("FAC");
		supportedSegment.add("FHS");
		supportedSegment.add("FT1");
		supportedSegment.add("FTS");
		supportedSegment.add("GOL");
		supportedSegment.add("GP1");
		supportedSegment.add("GP2");
		supportedSegment.add("GT1");
		supportedSegment.add("Hxx");
		supportedSegment.add("IAM");
		supportedSegment.add("IIM");
		supportedSegment.add("ILT");
		supportedSegment.add("IN1");
		supportedSegment.add("IN2");
		supportedSegment.add("IN3");
		supportedSegment.add("INV");
		supportedSegment.add("IPC");
		supportedSegment.add("IPR");
		supportedSegment.add("ISD");
		supportedSegment.add("ITM");
		supportedSegment.add("IVC");
		supportedSegment.add("IVT");
		supportedSegment.add("LAN");
		supportedSegment.add("LCC");
		supportedSegment.add("LCH");
		supportedSegment.add("LDP");
		supportedSegment.add("LOC");
		supportedSegment.add("LRL");
		supportedSegment.add("MFA");
		supportedSegment.add("MFE");
		supportedSegment.add("MFI");
		supportedSegment.add("MRG");
		supportedSegment.add("MSA");
		supportedSegment.add("MSH");
		supportedSegment.add("NCK");
		supportedSegment.add("NDS");
		supportedSegment.add("NK1");
		supportedSegment.add("NPU");
		supportedSegment.add("NSC");
		supportedSegment.add("NST");
		supportedSegment.add("NTE");
		supportedSegment.add("OBR");
		supportedSegment.add("OBX");
		supportedSegment.add("ODS");
		supportedSegment.add("ODT");
		supportedSegment.add("OM1");
		supportedSegment.add("OM2");
		supportedSegment.add("OM3");
		supportedSegment.add("OM4");
		supportedSegment.add("OM5");
		supportedSegment.add("OM6");
		supportedSegment.add("OM7");
		supportedSegment.add("ORC");
		supportedSegment.add("ORG");
		supportedSegment.add("OVR");
		supportedSegment.add("PCE");
		supportedSegment.add("PCR");
		supportedSegment.add("PD1");
		supportedSegment.add("PDA");
		supportedSegment.add("PDC");
		supportedSegment.add("PEO");
		supportedSegment.add("PES");
		supportedSegment.add("PID");
		supportedSegment.add("PKG");
		supportedSegment.add("PMT");
		supportedSegment.add("PR1");
		supportedSegment.add("PRA");
		supportedSegment.add("PRB");
		supportedSegment.add("PRC");
		supportedSegment.add("PRD");
		supportedSegment.add("PSG");
		supportedSegment.add("PSH");
		supportedSegment.add("PSL");
		supportedSegment.add("PSS");
		supportedSegment.add("PTH");
		supportedSegment.add("PV1");
		supportedSegment.add("PV2");
		supportedSegment.add("PYE");
		supportedSegment.add("QAK");
		supportedSegment.add("QID");
		supportedSegment.add("QPD");
		supportedSegment.add("QRD");
		supportedSegment.add("QRF");
		supportedSegment.add("QRI");
		supportedSegment.add("RCP");
		supportedSegment.add("RDF");
		supportedSegment.add("RDT");
		supportedSegment.add("REL");
		supportedSegment.add("RF1");
		supportedSegment.add("RFI");
		supportedSegment.add("RGS");
		supportedSegment.add("RMI");
		supportedSegment.add("ROL");
		supportedSegment.add("RQ1");
		supportedSegment.add("RQD");
		supportedSegment.add("RXA");
		supportedSegment.add("RXC");
		supportedSegment.add("RXD");
		supportedSegment.add("RXE");
		supportedSegment.add("RXG");
		supportedSegment.add("RXO");
		supportedSegment.add("RXR");
		supportedSegment.add("SAC");
		supportedSegment.add("SCD");
		supportedSegment.add("SCH");
		supportedSegment.add("SCP");
		supportedSegment.add("SDD");
		supportedSegment.add("SFT");
		supportedSegment.add("SID");
		supportedSegment.add("SLT");
		supportedSegment.add("SPM");
		supportedSegment.add("STF");
		supportedSegment.add("STZ");
		supportedSegment.add("TCC");
		supportedSegment.add("TCD");
		supportedSegment.add("TQ1");
		supportedSegment.add("TQ2");
		supportedSegment.add("TXA");
		supportedSegment.add("UAC");
		supportedSegment.add("UB1");
		supportedSegment.add("UB2");
		supportedSegment.add("URD");
		supportedSegment.add("URS");
		supportedSegment.add("VAR");
		supportedSegment.add("VND");
		supportedSegment.add("ZL7");
		supportedSegment.add("Zxx");
    }
    
    public static boolean contains(String tok) {
    	return supportedSegment.contains(tok);
    }
    
}
