/*
 *  Prison is a Minecraft plugin for the prison game mode.
 *  Copyright (C) 2017 The Prison Team
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package tech.mcprison.prison.modules;

/**
 * Stores data on the status of the module.
 *
 * @author Faizaan A. Datoo
 * @since API 1.1
 */
public class ModuleStatus {

    /*
     * Enums
     */


    public enum Status {

        ENABLED, DISABLED, FAILED

    }

    /*
     * Fields & Constants
     */

    private Status status;
    private String message;

    /*
     * Methods
     */

    /**
     * Quickly set a module to the {@link Status#ENABLED} status, and set the message to "&aEnabled".
     */
    public void toEnabled() {
        setStatus(Status.ENABLED);
        setMessage("&aEnabled");
    }

    /**
     * Quickly set a module to the {@link Status#DISABLED} status, and set the message to "&cDisabled".
     */
    public void toDisabled() {
        setStatus(Status.DISABLED);
        setMessage("&cDisabled");
    }

    /**
     * Quickly set a module to the {@link Status#FAILED} status.
     *
     * @param reason The message to set. Supports amp-prefixed color codes.
     */
    public void toFailed(String reason) {
        setStatus(Status.FAILED);
        setMessage(reason);
    }

    /*
     * Getters & Setters
     */

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}