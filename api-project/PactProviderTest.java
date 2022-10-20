package activities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;

import au.com.dius.pact.core.model.annotations.PactFolder;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;

import org.junit.jupiter.api.extension.ExtendWith;

@Provider("UserProvider")
@PactFolder("target/pacts")
public class PactProviderTest {
	
	@BeforeEach
	void before(PactVerificationContext context) {
	    // Set target for provider to send request to
	    context.setTarget(new HttpTestTarget("localhost", 8585));
	}
	    @TestTemplate
	    @ExtendWith(PactVerificationInvocationContextProvider.class)
	    public void providerTests(PactVerificationContext context){
	        context.verifyInteraction();
	    }
	    
	    @State("A request to create a user")
	    public void state1(){}
	
}
