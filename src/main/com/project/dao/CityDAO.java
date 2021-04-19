
package main.com.project.dao;

import java.util.List;

import com.project.model.CityVO;

public interface CityDAO {

	public void insertCity(CityVO cityVO) ;
	public List searchCity(CityVO AreaView);
	public void deleteCity(CityVO AreaView);
	public List editCity(CityVO AreaView);
	public void updateCity(CityVO AreaView);
}
