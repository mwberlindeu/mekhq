/*
 * ActivateUnitAction.java
 *
 * Copyright (c) 2019 Megamek Team. All rights reserved.
 *
 * This file is part of MekHQ.
 *
 * MekHQ is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MekHQ is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MekHQ.  If not, see <http://www.gnu.org/licenses/>.
 */

package mekhq.campaign.unit.actions;

<<<<<<< HEAD
import java.util.UUID;

import megamek.common.annotations.Nullable;
import mekhq.campaign.Campaign;
=======
import megamek.common.annotations.Nullable;
import mekhq.campaign.Campaign;
import mekhq.campaign.personnel.Person;
>>>>>>> origin/master
import mekhq.campaign.unit.Unit;

/**
 * Activates a unit.
 */
public class ActivateUnitAction implements IUnitAction {

<<<<<<< HEAD
    private final UUID techId;
=======
    private final Person tech;
>>>>>>> origin/master
    private final boolean isGM;

    /**
     * Initializes a new instance of the ActivateUnitAction class.
<<<<<<< HEAD
     * @param techId The ID of the technician performing the work, or null
     *               if noone is needed to perform the work (self crewed or GM).
     * @param isGM A boolean value indicating whether or not GM mode should be used
     *             to complete the action.
     */
    public ActivateUnitAction(@Nullable UUID techId, boolean isGM) {
        this.techId = techId;
=======
     * @param tech The technician performing the work, or null
     *             if noone is needed to perform the work (self crewed or GM).
     * @param isGM A boolean value indicating whether or not GM mode should be used
     *             to complete the action.
     */
    public ActivateUnitAction(@Nullable Person tech, boolean isGM) {
        this.tech = tech;
>>>>>>> origin/master
        this.isGM = isGM;
    }

    @Override
<<<<<<< HEAD
    public void Execute(Campaign campaign, Unit unit) {
=======
    public void execute(Campaign campaign, Unit unit) {
>>>>>>> origin/master
        if (isGM) {
            unit.startActivating(null, true);
        }
        else {
<<<<<<< HEAD
            if (!unit.isSelfCrewed() && null == techId) {
                return;
            }

            unit.startActivating(techId);
=======
            if (!unit.isSelfCrewed() && (null == tech)) {
                return;
            }

            unit.startActivating(tech);
>>>>>>> origin/master
        }
    }
}
