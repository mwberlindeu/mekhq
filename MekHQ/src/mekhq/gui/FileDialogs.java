/*
 * Copyright (c) 2018 The MegaMek Team. All rights reserved.
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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MekHQ. If not, see <http://www.gnu.org/licenses/>.
 */
package mekhq.gui;

import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javax.swing.JFrame;

import mekhq.MekHQ;
import mekhq.MekHqConstants;
import mekhq.campaign.Campaign;
import mekhq.campaign.CampaignPreset;
import mekhq.campaign.mission.Scenario;
import mekhq.campaign.mission.ScenarioTemplate;
import mekhq.io.FileType;

/**
 * Utility class with methods to show the various open/save file dialogs
 */
public class FileDialogs {

    private FileDialogs() {
        // no instances
    }

    /**
     * Displays a dialog window from which the user can select an <tt>.xml</tt> file to open.
     *
     * @return the file selected, if any
     */
    public static Optional<File> openPersonnel(JFrame frame) {
        Optional<File> value = GUI.fileDialogOpen(
                frame,
                "Load Personnel",
                FileType.PRSX,
                MekHQ.getPersonnelDirectory().getValue());

        value.ifPresent(x -> MekHQ.getPersonnelDirectory().setValue(x.getParent()));
        return value;
    }

    /**
     * Displays a dialog window from which the user can select an <tt>.xml</tt> file to open.
     *
     * @return the file selected, if any
     */
    public static Optional<File> savePersonnel(JFrame frame, Campaign campaign) {

        String fileName = String.format(
                "%s%s_ExportedPersonnel.prsx",
                campaign.getName(),
                campaign.getLocalDate().format(DateTimeFormatter.ofPattern(MekHqConstants.FILENAME_DATE_FORMAT)));

        Optional<File> value = GUI.fileDialogSave(
                frame,
                "Save Personnel",
                FileType.PRSX,
                MekHQ.getPersonnelDirectory().getValue(),
                fileName);

        value.ifPresent(x -> MekHQ.getPersonnelDirectory().setValue(x.getParent()));
        return value;
    }

    /**
     * Displays a dialog window from which the user can select an <tt>.xml</tt> file to open.
     *
     * @return the file selected, if any
     */
    public static Optional<File> openRankSystems(final JFrame frame) {
        Optional<File> value = GUI.fileDialogOpen(frame, "Load Rank Systems",
                FileType.XML, MekHQ.getMekHQOptions().getRankSystemsPath());
        value.ifPresent(x -> MekHQ.getMekHQOptions().setRankSystemsPath(x.getParent()));
        return value;
    }

    /**
     * Displays a dialog window from which the user can select a <tt>.xml</tt> file to save to.
     *
     * @return the file selected, if any
     */
    public static Optional<File> saveRankSystems(final JFrame frame) {
        Optional<File> value = GUI.fileDialogSave(frame, "Save Rank Systems", FileType.XML,
                MekHQ.getMekHQOptions().getRankSystemsPath(), "rankSystem.xml");
        value.ifPresent(x -> MekHQ.getMekHQOptions().setRankSystemsPath(x.getParent()));
        return value;
    }

    /**
     * Displays a dialog window from which the user can select an <tt>.xml</tt> file to open.
     *
     * @return the file selected, if any
     */
    public static Optional<File> openIndividualRankSystem(final JFrame frame) {
        Optional<File> value = GUI.fileDialogOpen(frame, "Load Individual Rank System",
                FileType.XML, MekHQ.getMekHQOptions().getIndividualRankSystemPath());
        value.ifPresent(x -> MekHQ.getMekHQOptions().setIndividualRankSystemPath(x.getParent()));
        return value;
    }

    /**
     * Displays a dialog window from which the user can select a <tt>.xml</tt> file to save to.
     *
     * @return the file selected, if any
     */
    public static Optional<File> saveIndividualRankSystem(final JFrame frame) {
        Optional<File> value = GUI.fileDialogSave(frame, "Save Individual Rank System",
                FileType.XML, MekHQ.getMekHQOptions().getIndividualRankSystemPath(),
                "individualRankSystem.xml");
        value.ifPresent(x -> MekHQ.getMekHQOptions().setIndividualRankSystemPath(x.getParent()));
        return value;
    }

    /**
     * Displays a dialog window from which the user can select a <tt>.png</tt> file to save to.
     *
     * @return the file selected, if any
     */
    public static Optional<File> exportLayeredForceIcon(final JFrame frame) {
        Optional<File> value = GUI.fileDialogSave(frame, "Export Layered Force Icon",
                FileType.PNG, MekHQ.getMekHQOptions().getLayeredForceIconPath(),
                "layeredForceIcon.png");
        value.ifPresent(x -> MekHQ.getMekHQOptions().setLayeredForceIconPath(x.getParent()));
        return value;
    }

    /**
     * Displays a dialog window from which the user can select a <tt>.mul</tt> file to save to.
     *
     * @return the file selected, if any
     */
    public static Optional<File> saveCampaignPreset(final JFrame frame, final CampaignPreset preset) {
        return GUI.fileDialogSave(frame, "Save Campaign Preset", FileType.XML,
                MekHqConstants.USER_CAMPAIGN_PRESET_DIRECTORY, preset + " Preset.xml");
    }

    /**
     * Displays a dialog window from which the user can select a <tt>.parts</tt> file to open.
     *
     * @return the file selected, if any
     */
    public static Optional<File> openParts(JFrame frame) {
        Optional<File> value = GUI.fileDialogOpen(
                frame,
                "Load Parts",
                FileType.PARTS,
                MekHQ.getPartsDirectory().getValue());

        value.ifPresent(x -> MekHQ.getPartsDirectory().setValue(x.getParent()));
        return value;
    }

    /**
     * Displays a dialog window from which the user can select a <tt>.parts</tt> file to save to.
     *
     * @return the file selected, if any
     */
    public static Optional<File> saveParts(JFrame frame, Campaign campaign) {
        String fileName = String.format(
                "%s%s_ExportedParts.parts",
                campaign.getName(),
                campaign.getLocalDate().format(DateTimeFormatter.ofPattern(MekHqConstants.FILENAME_DATE_FORMAT)));

        Optional<File> value =  GUI.fileDialogSave(
                frame,
                "Save Parts",
                FileType.PARTS,
                MekHQ.getPartsDirectory().getValue(),
                fileName);

        value.ifPresent(x -> MekHQ.getPartsDirectory().setValue(x.getParent()));
        return value;
    }

    /**
     * Displays a dialog window from which the user can select a <tt>.mul</tt> file to open.
     *
     * @return the file selected, if any
     */
    public static Optional<File> openUnits(JFrame frame) {
        Optional<File> value = GUI.fileDialogOpen(
                frame,
                "Load Units",
                FileType.MUL,
                MekHQ.getUnitsDirectory().getValue());

        value.ifPresent(x -> MekHQ.getUnitsDirectory().setValue(x.getParent()));
        return value;
    }

    /**
     * Displays a dialog window from which the user can select a <tt>.mul</tt> file to save to.
     *
     * @return the file selected, if any
     */
    public static Optional<File> saveDeployUnits(JFrame frame, Scenario scenario) {
        Optional<File> value = GUI.fileDialogSave(
                frame,
                "Deploy Units",
                FileType.MUL,
                MekHQ.getUnitsDirectory().getValue(),
                scenario.getName() + ".mul");

        value.ifPresent(x -> MekHQ.getUnitsDirectory().setValue(x.getParent()));
        return value;
    }

    /**
     * Displays a dialog window from which the user can select a campaign file to open.
     *
     * @return the file selected, if any
     */
    public static Optional<File> openCampaign(JFrame frame) {
        Optional<File> value = GUI.fileDialogOpen(
                frame,
                "Load Campaign",
                FileType.CPNX,
                MekHQ.getCampaignsDirectory().getValue());

        value.ifPresent(x -> MekHQ.getCampaignsDirectory().setValue(x.getParent()));
        return value;
    }

    /**
     * Displays a dialog window from which the user can select a campaign file to save to.
     *
     * @return the file selected, if any
     */
    public static Optional<File> saveCampaign(JFrame frame, Campaign campaign) {
        String fileName = String.format("%s%s.%s", campaign.getName(),
                campaign.getLocalDate().format(DateTimeFormatter.ofPattern(MekHqConstants.FILENAME_DATE_FORMAT)),
                MekHQ.getMekHQOptions().getPreferGzippedOutput() ? "cpnx.gz" : "cpnx" );

        Optional<File> value = GUI.fileDialogSave(frame, "Save Campaign", FileType.CPNX,
                MekHQ.getCampaignsDirectory().getValue(), fileName);

        value.ifPresent(x -> MekHQ.getCampaignsDirectory().setValue(x.getParent()));
        return value;
    }

    /**
     * Displays a dialog window from which the user can select a scenario template file to open
     *
     * @return the file selected, if any
     */
    public static Optional<File> openScenarioTemplate(JFrame frame) {
        Optional<File> value = GUI.fileDialogOpen(
                frame,
                "Load Scenario Template",
                FileType.XML,
                MekHQ.getScenarioTemplatesDirectory().getValue());

        value.ifPresent(x -> MekHQ.getScenarioTemplatesDirectory().setValue(x.getParent()));
        return value;
    }

    /**
     * Displays a dialog window from which the user can select a scenario template file to save to.
     *
     * @return the file selected, if any
     */
    public static Optional<File> saveScenarioTemplate(JFrame frame, ScenarioTemplate template) {

        String fileName = String.format(
                "%s.xml", //$NON-NLS-1$
                template.name);

        Optional<File> value = GUI.fileDialogSave(
                frame,
                "Save Scenario Template",
                FileType.XML,
                MekHQ.getScenarioTemplatesDirectory().getValue(),
                fileName);

        value.ifPresent(x -> MekHQ.getScenarioTemplatesDirectory().setValue(x.getParent()));
        return value;
    }

    /**
     * Displays a dialog window from which the user can select a <tt>.tsv</tt> file to open.
     *
     * @return the file selected, if any
     */
    public static Optional<File> openPlanetsTsv(JFrame frame) {
        Optional<File> value = GUI.fileDialogOpen(
                frame,
                "Load Planets from SUCS format TSV file",
                FileType.TSV,
                MekHQ.getPlanetsDirectory().getValue());

        value.ifPresent(x -> MekHQ.getPlanetsDirectory().setValue(x.getParent()));
        return value;
    }

    /**
     * Displays a dialog window from which the user can select a <tt>.png</tt> file to save to.
     *
     * @return the file selected, if any
     */
    public static Optional<File> saveStarMap(JFrame frame) {
        Optional<File> value = GUI.fileDialogSave(
                frame,
                "Save star map to PNG file",
                FileType.PNG,
                MekHQ.getStarMapsDirectory().getValue(),
                "starmap.png");

        value.ifPresent(x -> MekHQ.getStarMapsDirectory().setValue(x.getParent()));
        return value;
    }
}
