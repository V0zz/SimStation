/*
* Edit history:
* Arlan, 4/10: created SimFactory
* 
*/
package Simstation;

import mvc.*;

public interface SimFactory extends AppFactory {
	public View getView(Model model);
}
