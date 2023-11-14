/*
 *
 *  *
 *  *  * PROJECT:    Simple Build System
 *  *  * LICENSE:     GPL - See COPYING in the top level directory
 *  *  * PROGRAMMER:  Maltsev Daniil <brickexberiment@lenta.ru>
 *  *
 *
 */

package org.sbs;

public enum TokenType {
    XML,
    Version,
    Encoding,
    StartDeclaration,
    EndDeclaration,
    StartEndDeclaration,
    EndEndDeclaration,
    Comma,
    Identifier,
    DeclarationIdentifier,
    XMLHeader,
    DefinitionHeader,
    DefinitionHeaderEnd,
    Block,
    XMLFile
}
