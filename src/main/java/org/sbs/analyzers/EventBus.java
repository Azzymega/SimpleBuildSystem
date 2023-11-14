/*
 *
 *  *
 *  *  * PROJECT:    Simple Build System
 *  *  * LICENSE:     GPL - See COPYING in the top level directory
 *  *  * PROGRAMMER:  Maltsev Daniil <brickexberiment@lenta.ru>
 *  *
 *
 */

package org.sbs.analyzers;

public class EventBus implements IEventConflict<EventBus,AnalyzeEvent> {
    @Override
    public EventBus EventResolve(AnalyzeEvent Object) {
        System.out.println(Object.getTextEvent());
        return null;
    }
}
