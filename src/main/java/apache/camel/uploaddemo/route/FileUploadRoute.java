package apache.camel.uploaddemo.route;

import org.apache.camel.Processor;
import org.apache.camel.main.Main;

import apache.camel.uploaddemo.processor.UploadProcessor;



public class FileUploadRoute extends ConfigurationRoute{

    private Processor processor;

    public FileUploadRoute(Processor processor){
        this.processor = processor;
    }

    @Override
    public void configure() throws Exception {
        super.configure();
        rest("/file/upload/demo")
                .description("file Upload demo camel")
                .consumes("multipart/form-data")
                .produces("application/json")
                .post()
                .to("direct:fileUploadProcessor");

        from("direct:fileUploadProcessor")
                .routeId("fileUploadProcessorRouteId")
                .process(processor);
    }
    
    public static void main(String[] args) throws Exception {
        FileUploadRoute uploadService = new FileUploadRoute(new UploadProcessor());
        Main main = new Main();
        main.addRouteBuilder(uploadService);
        main.run(args);

        Runtime.getRuntime().addShutdownHook(new Thread(main::completed));

    }
}
