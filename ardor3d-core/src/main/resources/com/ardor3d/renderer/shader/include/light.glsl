#ifndef LIGHT_INC
#define LIGHT_INC

#ifndef MAX_LIGHTS
#define MAX_LIGHTS 8
#endif

#ifndef MAX_SHADOWS
#define MAX_SHADOWS 8
#endif

#define LIGHT_DIRECTIONAL 0
#define LIGHT_POINT 1
#define LIGHT_SPOT 2
// XXX: Unused currently
#define LIGHT_AREA 3

struct Light {
	int type;
	bool enabled;
	
	// shadow info
	bool castsShadows;
	mat4 shadowMatrix;
	
	// Point and Spot
    vec3 position;
    
    // Directional and Spot
    vec3 direction;
    
    // attenuation - Point and Spot
    float constant;
    float linear;
    float quadratic;
    float range;
    
    // All types
    vec3 color;
    float intensity;

	// Spot only
    float angle;
    float innerAngle;
};

struct LightingResult {
    vec3 diffuse;
    vec3 specular;
};

uniform struct LightProperties {
	vec3 globalAmbient;
	Light lights[MAX_LIGHTS];
	sampler2DArrayShadow shadowMaps[MAX_SHADOWS];
} lightProps;

#endif