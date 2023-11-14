/*
 *
 *  *
 *  *  * PROJECT:    Simple Build System
 *  *  * LICENSE:     GPL - See COPYING in the top level directory
 *  *  * PROGRAMMER:  Maltsev Daniil <brickexberiment@lenta.ru>
 *  *
 *
 */

package org.sbs.wrappers;

import org.sbs.Token;

import java.util.ArrayList;

public abstract class Part {
    public abstract Token IsWork(ArrayList<Token> tokens);
}
