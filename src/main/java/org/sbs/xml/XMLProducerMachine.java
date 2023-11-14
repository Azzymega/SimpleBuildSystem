package org.sbs.xml;

import org.sbs.BuildConfiguration;
import org.sbs.analyzers.IAnalyzeConflict;
import org.sbs.wrappers.XMLHeader;

public class XMLProducerMachine implements IAnalyzeConflict<XMLProducerMachine,BuildConfiguration> {
    private BlockProducingMachine blockProducingMachine = new BlockProducingMachine();
    @Override
    public XMLProducerMachine AnalyzeResolve(BuildConfiguration Object) {
        XMLMetadata header = new XMLMetadata(Object.getTree().get(0).getTokens().get(1).getTokens().get(2).getValue(),
                Object.getTree().get(0).getTokens().get(1).getTokens().get(1).getValue());
        Object.setXml(new XML(header));
        blockProducingMachine.AnalyzeResolve(Object);
        return null;
    }
}
