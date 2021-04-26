export interface UserPolicy    {
    user: {
        userId: number,
        firstName: string,
        lastName: string,
        email: string,
        phoneNo: string,
        city: string,
        password: string
    },
    policy: {
        policyId: number,
        policyName: string,
        policyDescription: string,
        duration: number,
        premiumAmount: number,
        policyType: string
    },
    claimedPolicy: {
        planId: number,
        userId: number,
        policyId: number,
        claimedDate: string,
        status: boolean
    }
}

