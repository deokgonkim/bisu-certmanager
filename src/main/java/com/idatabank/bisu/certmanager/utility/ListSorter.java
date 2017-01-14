package com.idatabank.bisu.certmanager.utility;

import com.idatabank.bisu.certmanager.CertEntity;

import com.idatabank.bisu.certmanager.CertNameComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListSorter {
    public ListSorter() {
    }
    
    public static List sortByExpire(List<CertEntity> org) {
        List fin = null;
        CertEntity[] entities = (CertEntity[])org.toArray();
        
        for ( int i = 0 ; i < entities.length ; i ++ ) {
            for ( int j = i + 1 ; j < entities.length ; j ++ ) {
                CertEntity e1 = null;
                CertEntity e2 = null;
                CertEntity t = null;
                e1 = entities[i];
                e2 = entities[j];
                if ( e1.getNotAfter().compareTo(e2.getNotAfter()) > 0 ) {
                    t = e1;
                    e1 = e2;
                    e2 = t;
                }
            }
        }
        
        fin = new LinkedList();
        for ( int i = 0 ; i < entities.length ; i ++ ) {
            fin.add(entities[i]);
        }
        return fin;
    }
    
    public static List sortByName(List<CertEntity> org) {
        List fin = null;
        Object[] entities = org.toArray();
        
        for ( int i = 0 ; i < entities.length ; i ++ ) {
            for ( int j = i + 1 ; j < entities.length ; j ++ ) {
                CertEntity e1 = null;
                CertEntity e2 = null;
                CertEntity t = null;
                e1 = (CertEntity)entities[i];
                e2 = (CertEntity)entities[j];
                if ( e1.getName().compareTo(e2.getName()) > 0 ) {
                    t = e1;
                    e1 = e2;
                    e2 = t;
                }
            }
        }
        
        Arrays.sort(entities, new CertNameComparator());
        
        fin = new ArrayList();
        for ( int i = 0 ; i < entities.length ; i ++ ) {
            fin.add(entities[i]);
        }
        return fin;
    }
}
