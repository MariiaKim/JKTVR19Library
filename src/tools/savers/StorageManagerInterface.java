/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.savers;

/**
 *
 * @author pupil
 */
import java.util.List;


public interface StorageManagerInterface {
    public void save(List arrayList, String fileName);
    public List load(String fileName);
}
