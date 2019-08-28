/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import sounds.Sound;

/**
 *
 * @author kasra
 */
public class Level4 extends Level {

    private boolean bool = true, bool2 = true;

    public Level4(GameState state) {

	super(state);
	state.sky.storedSun = 500;
	state.planetsInTheBar[0] = new PlantInPlantBar(1, 0);
	state.planetsInTheBar[1] = new PlantInPlantBar(2, 1);
	state.planetsInTheBar[2] = new PlantInPlantBar(3, 2);
	state.planetsInTheBar[3] = new PlantInPlantBar(4, 3);
	state.planetsInTheBar[4] = new PlantInPlantBar(5, 4);
	state.planetsInTheBar[5] = new PlantInPlantBar(6, 5);

    }

    public void update() {

	if (!roundOneIsDone) {

	    super.update();

	    if ((System.currentTimeMillis() - startTime) / 1000 > 15 - counter) {
		if (FirstSound) {
		    Sound.playSound("ZombieComing.wav");
		    FirstSound = false;
		}
		i = random.nextInt(5);
		if (counter > 1) {
		    while (true) {
			k = random.nextInt(5);
			if (k != i) {
			    state.rows[k].makeAZombie(1 + random.nextInt(2));
			    break;
			}
		    }
		}
		state.rows[i].makeAZombie(1);
		startTime = System.currentTimeMillis();
		counter++;

	    }
	    if (counter > 4) {
		roundOneIsDone = true;
	    }

	} else if (!roundTwoIsDone) {

	    if ((System.currentTimeMillis() - startTime) / 1000 > 17 - counter) {

		i = random.nextInt(5);
		if (bool) {
		    state.rows[i].makeAZombie(1 + random.nextInt(2));
		} else {
		    state.rows[i].makeAZombie(1 + random.nextInt(3));
		}
		//makes another zombie in another line
		while (true) {
		    k = random.nextInt(5);
		    if (k != i) {
			state.rows[k].makeAZombie(1 + random.nextInt(5));
			break;
		    }
		}
		//
		bool = !bool;
		startTime = System.currentTimeMillis();
		counter++;

	    }
	    if (counter > 10) {
		roundTwoIsDone = true;
	    }

	} /**
	 * performing huge wave
	 */
	else {
	    if (FirstSoundH) {
		Sound.playSound("Hojoom.wav");
		FirstSoundH = false;
	    }
	    if (counter > 15) {

		if (bool2) {
		    for (int i = 0; i < state.rows.length; i++) {
			state.rows[i].makeAZombie(2 + random.nextInt(4));
		    }
		    bool2 = false;
		}

		if (state.allZombiesAreDead()) {
		    levelIsDone = true;
		}

	    } else if ((System.currentTimeMillis() - startTime) / 1000 > 17 - counter && !levelIsDone) {

		i = random.nextInt(5);
		state.rows[i].makeAZombie(1 + random.nextInt(1 + random.nextInt(4)));

		while (true) {
		    j = random.nextInt(5);
		    if (j != i) {
			state.rows[j].makeAZombie(1 + random.nextInt(3 + random.nextInt(2)));
			break;
		    }
		}
		while (true) {
		    k = random.nextInt(5);
		    if (k != i && k != j) {
			state.rows[k].makeAZombie(1 + random.nextInt(4 + random.nextInt(2)));
			break;
		    }
		}

		startTime = System.currentTimeMillis();
		counter += 2;

	    }

	}

    }

}
