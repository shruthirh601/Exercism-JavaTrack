import java.util.*;

class ProteinTranslator {

    List<String> translate(String rnaSequence) {
        List<String> finalSequence = new ArrayList<>();
        if (rnaSequence.length() % 3 != 0 && !(rnaSequence.contains("UAA") || rnaSequence.contains("UAG") || rnaSequence.contains("UGA"))) {
            throw new IllegalArgumentException("Invalid codon");
        }
        for(int i=0;i <rnaSequence.length(); i+=3){
            String subSequence = rnaSequence.substring(i, i+3);
            String aminoAcid = this.getAminoAcid(subSequence);
            if(aminoAcid.equals("STOP"))
                break;
            finalSequence.add(aminoAcid);
        }
        return finalSequence;
    }

    String getAminoAcid(String sequence){
        String aminoAcid = "";
        switch(sequence){
            case "AUG": aminoAcid = "Methionine";
                break;
            case "UUU":
            case "UUC": aminoAcid = "Phenylalanine";
                break;
            case "UUA":
            case "UUG": aminoAcid = "Leucine";
                break;
            case "UCU":
            case "UCC":
            case "UCA":
            case "UCG": aminoAcid = "Serine";
                break;
            case "UAU": 
            case "UAC" : aminoAcid="Tyrosine";
                break;
            case "UGU":
            case "UGC" : aminoAcid = "Cysteine";
                break;
            case "UGG": aminoAcid = "Tryptophan";
                break;
            case "UAA":
            case "UAG":
            case "UGA": aminoAcid= "STOP";
                break;
            default: throw new IllegalArgumentException("Invalid codon");
        }
        return aminoAcid;
    }
}
