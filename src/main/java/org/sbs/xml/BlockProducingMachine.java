/*
 *
 *  *
 *  *  * PROJECT:    Simple Build System
 *  *  * LICENSE:     GPL - See COPYING in the top level directory
 *  *  * PROGRAMMER:  Maltsev Daniil <brickexberiment@lenta.ru>
 *  *
 *
 */

package org.sbs.xml;

import org.sbs.BuildConfiguration;
import org.sbs.Token;
import org.sbs.TokenType;
import org.sbs.analyzers.IAnalyzeConflict;

public class BlockProducingMachine implements IAnalyzeConflict<BlockProducingMachine, BuildConfiguration>,
IProduceConflict<XMLArray,Token> {
    @Override
    public BlockProducingMachine AnalyzeResolve(BuildConfiguration Object) {
        Object.getXml().setArray(ProduceResolve(Object.getTree().get(0).getTokens().get(0)));
        return null;
    }

    @Override
    public XMLArray ProduceResolve(Token Object) {
        XMLArray newArr = null;
        for (Token init : Object.getTokens()) {
            if (init.getType() == TokenType.DefinitionHeaderEnd) {
                newArr = new XMLArray();
                newArr.setName(init.getTokens().get(1).getValue());
            } else if (init.getType() == TokenType.DefinitionHeader) {
                return newArr;
            } else if (init.getType() == TokenType.Identifier) {
                assert newArr != null;
                newArr.getObjects().add(new XMLObject(init.getValue()));
            } else if (init.getType() == TokenType.Block) {
                assert newArr != null;
                newArr.getArrays().add(ProduceResolve(init));
            }
        }
        return newArr;
    }
}
