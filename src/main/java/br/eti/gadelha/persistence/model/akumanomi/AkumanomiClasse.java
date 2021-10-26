package br.eti.gadelha.persistence.model.akumanomi;

import lombok.Getter;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter
public enum AkumanomiClasse {
    PARAMECIA("Paramecia"),
    ZOAN("Zoan"),
    LOGIA("Logia");

    String classe;

    private AkumanomiClasse(String classe) {
        this.classe = classe;
    }
    public String getStatus() {
        return this.classe;
    }
}