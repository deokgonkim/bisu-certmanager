package com.idatabank.bisu.certmanager;

import java.util.Comparator;

public class CertNameComparator implements Comparator {
    public CertNameComparator() {
    }

    public int compare(Object o1, Object o2) {
        return ((CertEntity)o1).getName().compareTo( ((CertEntity)o2).getName() );
    }
}
